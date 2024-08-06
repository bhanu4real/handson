package databases_day10;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductStore {
    Connection conn=null;

    public ProductStore() {
        conn=DBUtils.getConnection();
        System.out.println("Connection Successful");
    }

    public void addProduct(Product P) throws ProductAlreadyExistsException{
        String sql="insert into product values(?,?,?,?)";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select productid from product where productid="+P.getProductid());
            if(rs!=null) {
                PreparedStatement ps= conn.prepareStatement(sql);
                ps.setInt(1,P.getProductid());
                ps.setString(2,P.getProductname());
                ps.setString(3,P.getDescription());
                ps.setDouble(4,P.getPrice());
                ps.executeUpdate();
                System.out.println("Added product successfully");
            }
            else throw new ProductAlreadyExistsException("Product already exists");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void updateProduct(Product P){
        String sql="update Product set productid=?,productname=?,description=?,price=? where productid=?";
        PreparedStatement ps= null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,P.getProductid());
            ps.setString(2,P.getProductname());
            ps.setString(3,P.getDescription());
            ps.setDouble(4,P.getPrice());
            ps.setInt(5,P.getProductid());
            ps.executeUpdate();
            System.out.println("Updated product successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Product> getAllProducts(){
        List<Product> products=new ArrayList<Product>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from product";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Product P=new Product();
                P.setProductid(rs.getInt("productid"));
                P.setProductname(rs.getString("productname"));
                P.setDescription(rs.getString("description"));
                P.setPrice(rs.getDouble("price"));
                P.setProductid(rs.getInt("productid"));
                products.add(P);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;

    }
    public List<Product> getProductsByPrice(int price){
        String sql="select * from product where price="+price;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Product> products=new ArrayList<>();
        while (true){
            try {
                if (!rs.next()) break;
                Product P=new Product();
                P.setProductid(rs.getInt("productid"));
                P.setProductname(rs.getString("productname"));
                P.setDescription(rs.getString("description"));
                P.setPrice(rs.getDouble("price"));
                P.setProductid(rs.getInt("productid"));
                products.add(P);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return products;
    }

    public void addTwoProducts(Product p1, Product p2)throws ProductNotAddedException{
        //( Raise this exeception even if we are not able to add any one product. Use transactions for this opertion)
        String insertProductSQL = "INSERT INTO Product (productid, productname, description, price) VALUES (?, ?, ?, ?)";
        PreparedStatement ps=null;

        try {

            conn.setAutoCommit(false); // Begin transaction

            ps = conn.prepareStatement(insertProductSQL);

            // Add first product
            ps.setInt(1, p1.getProductid());
            ps.setString(2, p1.getProductname());
            ps.setString(3, p1.getDescription());
            ps.setDouble(4, p1.getPrice());
            ps.executeUpdate();

            // Add second product
            ps.setInt(1, p2.getProductid());
            ps.setString(2, p2.getProductname());
            ps.setString(3, p2.getDescription());
            ps.setDouble(4, p2.getPrice());
            ps.executeUpdate();

            conn.commit(); // Commit transaction

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback transaction on error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw new ProductNotAddedException("Failed to add products: " + e.getMessage());
        } finally {
            if (ps!= null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
