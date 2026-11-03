-- ==============================================================================
-- SEED DATA MẪU CHO HỆ THỐNG ĐẶT VÉ (CITIES, ARTISTS, EVENTS, SHOWTIMES, SEATS, SHOWTIME_SEATS)
-- ==============================================================================

-- 1. TẠO TÀI KHOẢN USER TEST
INSERT INTO users (id, email, full_name, password, role, status, created_at, updated_at)
VALUES (
    1,
    'customer_demo@example.com',
    'Nguyễn Văn A',
    '$2a$10$wE8wOq15J129vMlyvP6cTe1Z5X2J6.a1yF5jH7e9Y3M9V8g7d2J2y',
    'CUSTOMER',
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
) ON DUPLICATE KEY UPDATE id=id;

-- 2. TẠO DANH SÁCH THÀNH PHỐ (CITIES)
INSERT INTO cities (id, name, code, created_at, updated_at) VALUES
(1, 'Hà Nội', 'ha-noi', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'TP. Hồ Chí Minh', 'ho-chi-minh', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Đà Nẵng', 'da-nang', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Hải Phòng', 'hai-phong', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Cần Thơ', 'can-tho', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Đà Lạt', 'da-lat', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Nha Trang', 'nha-trang', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Huế', 'hue', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE name=VALUES(name), code=VALUES(code);

-- 4. TẠO PHÒNG CHIẾU / KHÁN PHÒNG (AUDITORIUM)
INSERT INTO auditoriums (id, name, total_seats, created_at, updated_at)
VALUES 
(1, 'Phòng chiếu 01 (IMAX Laser)', 32, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Khán phòng A - Nhà Hát Hòa Bình', 500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Khu Khán Đài A - Mỹ Đình', 5000, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE name=VALUES(name);

-- 5. TẠO 32 GHẾ MẪU TRONG PHÒNG CHIẾU 01 (SEATS)
INSERT INTO seats (id, auditorium_id, seat_row, seat_number, seat_code, seat_type, row_index, column_index, created_at, updated_at) VALUES
(1, 1, 'A', 1, 'A01', 'STANDARD', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, 'A', 2, 'A02', 'STANDARD', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 1, 'A', 3, 'A03', 'STANDARD', 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 1, 'A', 4, 'A04', 'STANDARD', 1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 1, 'A', 5, 'A05', 'STANDARD', 1, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 1, 'A', 6, 'A06', 'STANDARD', 1, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 1, 'A', 7, 'A07', 'STANDARD', 1, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 1, 'A', 8, 'A08', 'STANDARD', 1, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9,  1, 'B', 1, 'B01', 'STANDARD', 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 1, 'B', 2, 'B02', 'STANDARD', 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 1, 'B', 3, 'B03', 'STANDARD', 2, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 1, 'B', 4, 'B04', 'STANDARD', 2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 1, 'B', 5, 'B05', 'STANDARD', 2, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 1, 'B', 6, 'B06', 'STANDARD', 2, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 1, 'B', 7, 'B07', 'STANDARD', 2, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(16, 1, 'B', 8, 'B08', 'STANDARD', 2, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(17, 1, 'C', 1, 'C01', 'VIP', 3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 1, 'C', 2, 'C02', 'VIP', 3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 1, 'C', 3, 'C03', 'VIP', 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, 1, 'C', 4, 'C04', 'VIP', 3, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(21, 1, 'C', 5, 'C05', 'VIP', 3, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(22, 1, 'C', 6, 'C06', 'VIP', 3, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(23, 1, 'C', 7, 'C07', 'VIP', 3, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(24, 1, 'C', 8, 'C08', 'VIP', 3, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(25, 1, 'D', 1, 'D01', 'SWEETBOX', 4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(26, 1, 'D', 2, 'D02', 'SWEETBOX', 4, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(27, 1, 'D', 3, 'D03', 'SWEETBOX', 4, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(28, 1, 'D', 4, 'D04', 'SWEETBOX', 4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(29, 1, 'D', 5, 'D05', 'SWEETBOX', 4, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(30, 1, 'D', 6, 'D06', 'SWEETBOX', 4, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(31, 1, 'D', 7, 'D07', 'SWEETBOX', 4, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(32, 1, 'D', 8, 'D08', 'SWEETBOX', 4, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE seat_code=VALUES(seat_code);

-- 6. TẠO SỰ KIỆN (EVENTS)
-- Ghi chú: minPrice không lưu trong events, mà lấy từ MIN(showtimes.base_price)
INSERT INTO events (id, title, description, poster_url, category, city_id, location_name, start_date, duration_minutes, status, created_at, updated_at) VALUES
(
    1,
    'Dune: Hành Tinh Cát - Phần 2',
    'Bộ phim bom tấn khoa học viễn tưởng đạt nhiều giải thưởng quốc tế với những thước phim IMAX hoành tráng.',
    'https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=800&q=80',
    'MOVIE',
    1,
    'CGV Vincom Center Bà Triệu',
    '2026-11-15 19:30:00',
    166,
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    2,
    'Live Concert: Chân Trời Rực Rỡ',
    'Đêm nhạc đặc biệt hội ngộ giữa Hà Anh Tuấn và rapper Đen Vâu trong không gian âm nhạc thăng hoa và đầy cảm xúc.',
    'https://images.unsplash.com/photo-1470225620780-dba8ba36b745?w=800&q=80',
    'MUSIC',
    2,
    'Sân vận động Quân khu 7',
    '2026-11-20 20:00:00',
    180,
    'UPCOMING',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    3,
    'Bảo Tàng Của Nuối Tiếc - Vũ Tour',
    'Hòa nhạc riêng của Hoàng tử Indie Vũ cùng những giai điệu acoustic mộc mạc và sâu lắng.',
    'https://images.unsplash.com/photo-1514525253161-7a46d19cd819?w=800&q=80',
    'MUSIC',
    1,
    'Cung Điền Kinh Mỹ Đình',
    '2026-11-25 19:30:00',
    150,
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    4,
    'Kịch nói: Dạ Cổ Hoài Lang',
    'Vở kịch kinh điển đầy xúc động về tình cha con và nỗi niềm người xa xứ qua nét diễn tài hoa của dàn nghệ sĩ gạo cội.',
    'https://images.unsplash.com/photo-1507676184212-d03ab07a01bf?w=800&q=80',
    'STAGE',
    2,
    'Sân khấu Kịch IDECAF',
    '2026-11-28 19:00:00',
    140,
    'UPCOMING',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    5,
    'Giải Chạy Đêm VnExpress Marathon Midnight Hanoi',
    'Khám phá vẻ đẹp cổ kính ngàn năm của thủ đô Hà Nội trong bầu không khí se lạnh qua từng bước chạy rực rỡ.',
    'https://images.unsplash.com/photo-1452626038306-9aae5e071dd3?w=800&q=80',
    'SPORTS',
    1,
    'Quảng trường Đông Kinh Nghĩa Thục',
    '2026-12-05 03:00:00',
    300,
    'UPCOMING',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    6,
    'Workshop: Thiết Kế Trải Nghiệm Người Dùng (UI/UX)',
    'Khóa học thực chiến dành cho Designer và Product Manager nâng tầm sản phẩm số cùng các chuyên gia đầu ngành.',
    'https://images.unsplash.com/photo-1531403009284-440f080d1e12?w=800&q=80',
    'WORKSHOP',
    3,
    'Co-working Hub Đà Nẵng',
    '2026-12-10 09:00:00',
    240,
    'ACTIVE',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    7,
    'Tri Âm Concert - Mỹ Tâm',
    'Đêm nhạc tri ân người hâm mộ của họa mi tóc nâu Mỹ Tâm với quy mô hoành tráng và dàn âm thanh ánh sáng chuẩn quốc tế.',
    'https://images.unsplash.com/photo-1465847899084-d164df4dedc6?w=800&q=80',
    'MUSIC',
    2,
    'Sân vận động Thống Nhất',
    '2026-12-15 19:30:00',
    180,
    'UPCOMING',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
),
(
    8,
    'Đêm Nhạc Trẻ Sôi Động - MONO Live',
    'Bùng nổ cùng phong cách biểu diễn cuốn hút và những bản hit triệu views từ chàng nghệ sĩ trẻ tài năng.',
    'https://images.unsplash.com/photo-1501386761578-eac5c94b800a?w=800&q=80',
    'MUSIC',
    3,
    'Nhà Hát Trưng Vương Đà Nẵng',
    '2026-12-20 20:00:00',
    120,
    'UPCOMING',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
)
ON DUPLICATE KEY UPDATE 
    title=VALUES(title),
    description=VALUES(description),
    poster_url=VALUES(poster_url),
    category=VALUES(category),
    city_id=VALUES(city_id),
    location_name=VALUES(location_name),
    start_date=VALUES(start_date),
    duration_minutes=VALUES(duration_minutes),
    status=VALUES(status);

-- 7. LIÊN KẾT NGHỆ SĨ & SỰ KIỆN (EVENTS_ARTISTS)
INSERT INTO events_artists (id, event_id, artist_id, created_at, updated_at) VALUES
(1, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Event 2 (Hà Anh Tuấn)
(2, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Event 2 (Đen Vâu)
(3, 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Event 3 (Vũ)
(4, 4, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Event 4 (NSND Việt Anh)
(5, 7, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP), -- Event 7 (Mỹ Tâm)
(6, 8, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)  -- Event 8 (MONO)
ON DUPLICATE KEY UPDATE id=id;

-- 8. TẠO SUẤT DIỄN VÀ GIÁ VÉ GỐC (SHOWTIMES)
-- base_price ở đây chính là giá gốc khởi điểm (minPrice)
INSERT INTO showtimes (id, event_id, auditorium_id, start_time, end_time, base_price, status, created_at, updated_at) VALUES
(1, 1, 1, '2026-11-15 19:30:00', '2026-11-15 22:16:00', 80000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2, 2, '2026-11-20 20:00:00', '2026-11-20 23:00:00', 500000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 2, 2, '2026-11-21 20:00:00', '2026-11-21 23:00:00', 650000.00, 'SCHEDULED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 3, 3, '2026-11-25 19:30:00', '2026-11-25 22:00:00', 350000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 4, 2, '2026-11-28 19:00:00', '2026-11-28 21:20:00', 200000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 5, 3, '2026-12-05 03:00:00', '2026-12-05 08:00:00', 300000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 6, 2, '2026-12-10 09:00:00', '2026-12-10 13:00:00', 150000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 7, 3, '2026-12-15 19:30:00', '2026-12-15 22:30:00', 450000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 8, 2, '2026-12-20 20:00:00', '2026-12-20 22:00:00', 250000.00, 'OPEN_FOR_BOOKING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE 
    base_price=VALUES(base_price),
    start_time=VALUES(start_time),
    end_time=VALUES(end_time),
    status=VALUES(status);

-- 9. TẠO TRẠNG THÁI GHẾ CHO SUẤT 1 (SHOWTIME_SEATS)
INSERT INTO showtime_seats (id, showtime_id, seat_id, price, status, hold_expires_at, held_by_user_id, created_at, updated_at) VALUES
(1, 1, 1, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 1, 2, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 1, 3, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 1, 4, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 1, 5, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 1, 6, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 1, 7, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 1, 8, 80000.00, 'BLOCKED',   NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9,  1, 9,  80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 1, 10, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 1, 11, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 1, 12, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 1, 13, 80000.00, 'HOLDING',   '2026-11-15 20:00:00', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 1, 14, 80000.00, 'HOLDING',   '2026-11-15 20:00:00', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 1, 15, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(16, 1, 16, 80000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(17, 1, 17, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 1, 18, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 1, 19, 120000.00, 'BOOKED',    NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, 1, 20, 120000.00, 'BOOKED',    NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(21, 1, 21, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(22, 1, 22, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(23, 1, 23, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(24, 1, 24, 120000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(25, 1, 25, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(26, 1, 26, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(27, 1, 27, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(28, 1, 28, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(29, 1, 29, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(30, 1, 30, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(31, 1, 31, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(32, 1, 32, 180000.00, 'AVAILABLE', NULL, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)
ON DUPLICATE KEY UPDATE price=VALUES(price), status=VALUES(status);
