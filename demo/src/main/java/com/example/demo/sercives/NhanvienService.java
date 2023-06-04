package com.example.demo.sercives;

import com.example.demo.models.NhanVien;
import com.example.demo.repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanvienService {
    @Autowired
    private NhanvienRepository nhanvienRepository;

    public List<NhanVien> GetAll () {
        return nhanvienRepository.findAll();
    }

    public void save(NhanVien nhanVien) {
        nhanvienRepository.save(nhanVien);
    }

    public NhanVien get(String id) {
        return nhanvienRepository.findById(String.valueOf(id)).get();
    }

    public void delete(String id) {
        nhanvienRepository.deleteById(String.valueOf(id));
    }

}
