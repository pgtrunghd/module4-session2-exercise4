-- Chạy bằng tài khoản có quyền tạo database, ví dụ:
--   psql -U postgres -f init-databases.sql
CREATE DATABASE user_db;
CREATE DATABASE inventory_db;
CREATE DATABASE order_db;
-- Bảng users (user_db) và products (inventory_db) do Hibernate tạo khi service khởi động (ddl-auto=update).
