-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th6 04, 2023 lúc 01:51 PM
-- Phiên bản máy phục vụ: 5.7.25
-- Phiên bản PHP: 7.1.26

create database bachhoaxanh
use bachhoaxanh

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bachhoaxanh`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbsanpham`
--

CREATE TABLE `tbsanpham` (
  `maSP` int(11) NOT NULL COMMENT 'mã sản phẩm',
  `tenSP` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `loaiSP` int(11) NOT NULL,
  `giaSP` double NOT NULL,
  `tonKho` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbsanpham`
--

INSERT INTO `tbsanpham` (`maSP`, `tenSP`, `loaiSP`, `giaSP`, `tonKho`) VALUES
(8, 'thit 22', 1, 40000, 700),
(16, 'thit 26', 1, 40000, 800),
(17, 'Trung 3', 0, 50000, 900),
(18, 'Trung 3', 0, 50000, 100),
(20, 'Rau cu qua', 2, 50000, 600),
(21, 'thit 22', 1, 40000, 50),
(22, 'thit 22', 1, 40000, 60),
(25, 'trung vina', 0, 34322342, 900),
(26, 'trung heo', 2, 3000, 600);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbsanpham`
--
ALTER TABLE `tbsanpham`
  ADD PRIMARY KEY (`maSP`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbsanpham`
--
ALTER TABLE `tbsanpham`
  MODIFY `maSP` int(11) NOT NULL AUTO_INCREMENT COMMENT 'mã sản phẩm', AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
