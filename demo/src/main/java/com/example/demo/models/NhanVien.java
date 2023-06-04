package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")

public class NhanVien {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 3, message = "Phải nhập vào 3 ký tự bao gồm chữ và số")
    @Column(name = "Ma_NV")
    private String id;

    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 3, max = 100, message = "Phải nhập tên nhân viên")
    @Column(name = "Ten_NV")
    private String tenNv;

    @Length(min = 0, max = 3, message = "nhập giới tính")
    @Column(name = "Phai")
    private String phai;

    @Length(min = 0, max = 200, message = "nhập nơi sinh")
    @Column(name = "Noi_sinh")
    private String noisinh;

    @Column(name = "Lương")
    private int luong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maphong")
    private PhongBan phongban;






}




