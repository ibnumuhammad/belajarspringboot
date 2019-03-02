/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajarspringboot;

import com.belajarspringboot.belajarspringboot.dao.datadao;
import com.belajarspringboot.belajarspringboot.model.Dummy;
import java.util.List;
import java.util.UUID;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author Home
 */

@SpringBootApplication
public class data {
    public static void main(String[]args){
        ApplicationContext context = SpringApplication.run(data.class, args);
        datadao dao = context.getBean(datadao.class);
        
         try{
             Dummy nik=  dao.findById("7371092304960001");
             System.out.println(nik.toString());
             nik.setNik("7371092304960002");
         }catch(EmptyResultDataAccessException erdae){
             erdae.printStackTrace();
             System.err.println("data tidak ditemukan");
         }
         System.out.println("--pencarian by nik dan nama--");
         
         List<Dummy> listbynikandnama = dao.findbynikandnama("2","i");
         System.out.println("jumlah data pencarian: "+listbynikandnama.size());
         for (Dummy data:listbynikandnama){
             System.out.println(data.toString());
                     
         }
    
//        List<Dummy> list = dao.daftardata();
//            for(Dummy data:list){
//                System.out.println(data.toString());

Dummy data = new Dummy();
data.setNik(UUID.fromString("nik").toString());
data.setNama("ismail");
data.setAlamat("makassar");
data.setTtl("makassar");
data.setPekerjaan("mahasiswa");
data.setKewarganegaraan("indonesia");
data.setKecamatan("jeneponto");

dao.save(data);
dao.delete(data.getNik());

        System.out.println("pencarian data semua setelah insert");
        
        List<Dummy> list= dao.daftardata();
        for (Dummy detail : list){
            System.out.println(detail.toString());
        }
    }
    }

