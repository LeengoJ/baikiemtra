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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "phongban")

public class PhongBan {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 2, max = 2, message = "Phải nhập vào 2 ký tự chữ viết tắt")
    private String maphong;

    @Length(min = 2, max = 30, message = "Phải nhập vào tên phòng")
    private String tenphong;
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
//    private Set<NhanVien> nhanVien;
    @OneToMany(mappedBy = "phongban", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanviens;
}




