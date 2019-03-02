/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajarspringboot.dao;

import com.belajarspringboot.belajarspringboot.data;
import com.belajarspringboot.belajarspringboot.model.Dummy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.PreparedStatementSetter;

/**
 *
 * @author Home
 */
@Repository
@Transactional(readOnly = true)
public class datadao {

    @Autowired
    private JdbcTemplate jdbc;
   

    public List<Dummy> daftardata() {
        String sql = "select* from identitas";
//        return this.jdbc.query(sql, new dRowMapper<Dummy>() {
//            @Override
//            public Dummy mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Dummy identitas = new Dummy(); //To change body of generated methods, choose Tools | Templates.
//
//                identitas.setNik(rs.getString("nik"));
//                identitas.setNama(rs.getString("nama"));
//                identitas.setAlamat(rs.getString("alamat"));
//                identitas.setTtl(rs.getString("ttl"));
//                identitas.setKewarganegaraan(rs.getString("kewarganegaraan"));
//                identitas.setKecamatan(rs.getString("kecamatan"));
//                return identitas;
//            }
//        });
return this.jdbc.query(sql, new DataRowMapper());
    }
    
    public Dummy findById(String primaryKey) throws EmptyResultDataAccessException{
        String sql = "select* from identitas where nik= ?";
        return this.jdbc.queryForObject(sql, new DataRowMapper(), new Object[] {primaryKey});
       
    }
    
    public List<Dummy>findbynikandnama(String nik, String nama){
        String sql ="select* from identitas where nik like ? and nama like ?";
        return this.jdbc.query(sql, new DataRowMapper(), new Object[]{ new StringBuilder("%").append(nik).append("%").toString(), new StringBuilder().append(nama).append("%").toString()});
    }

    @Transactional
    public void save(Dummy data){
        String sql = "insert into identitas(nik, nama, alamat, ttl, pekerjaan, kewarganegaraan, kecamatan) values(?, ?, ?, ?, ?, ?, ?)";
        this.jdbc.update(sql, new insertdata(data));
    }
    
    @Transactional
    public void update(Dummy data){
        String sql ="update identitas set "+"nama= ?,"+"alamat= ?,"+"ttl= ?,"+"pekerjaan= ?,"+"kewarganegaraan= ?,"+"kecamatan= ?,"+"where nik = ?,";
        this.jdbc.update(sql, new updatedata(data));
    }
    
    @Transactional
    public void delete(String nik){
        String sql ="delete from identitas where nik= ?";
        this.jdbc.update(sql, new Object[] {nik});
    }
    
    public class updatedata implements PreparedStatementSetter{
        final Dummy data;
        
        public updatedata(Dummy data){
            this.data =data;
        }
        
        @Override
        public void setValues(PreparedStatement ps)throws SQLException{
            ps.setString(1, data.getNik());
            ps.setString(2, data.getNama());
            ps.setString(3, data.getAlamat());
            ps.setString(4, data.getTtl());
            ps.setString(5, data.getPekerjaan());
            ps.setString(6, data.getKewarganegaraan());
            ps.setString(7, data.getKecamatan());
        }
    }
    
    public class insertdata implements PreparedStatementSetter{
        final Dummy data;
        
        public insertdata(Dummy data){
            this.data = data;
        }
        
        @Override
        public void setValues(PreparedStatement ps) throws SQLException{
            ps.setString(1, data.getNik());
            ps.setString(2, data.getNama());
            ps.setString(3, data.getAlamat());
            ps.setString(4, data.getTtl());
            ps.setString(5, data.getPekerjaan());
            ps.setString(6, data.getKewarganegaraan());
            ps.setString(7, data.getKecamatan());
        }
    }
    private class DataRowMapper implements RowMapper<Dummy> {

        @Override
            public Dummy mapRow(ResultSet rs, int rowNum) throws SQLException {
                Dummy identitas = new Dummy(); //To change body of generated methods, choose Tools | Templates.

                identitas.setNik(rs.getString("nik"));
                identitas.setNama(rs.getString("nama"));
                identitas.setAlamat(rs.getString("alamat"));
                identitas.setTtl(rs.getString("ttl"));
                identitas.setKewarganegaraan(rs.getString("kewarganegaraan"));
                identitas.setKecamatan(rs.getString("kecamatan"));
                return identitas;
            }
    }

}
