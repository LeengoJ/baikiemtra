package com.example.demo.repository;

import com.example.demo.models.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NhanvienRepository extends JpaRepository<NhanVien,String> {
}
