                                  ******** Tuỳ chọn trả lời một số câu hỏi bổ sung sau ***********

Nếu giao dịch được tổng hợp từ các hệ thống khác và định kỳ được tải lên hệ thống tích điểm, thì xử lý như thế nào trong trường hợp cấu hình quy đổi điểm bị thay đổi giữa các lần giao dịch của khách hàng.
VD: Khách hàng có 3 giao dịch mua hàng vào buổi sáng, và 2 giao dịch vào buổi chiều cùng ngày. Cấu hình quy đổi điểm được thay đổi vào 12h trưa ngày hôm đó. 22h cuối ngày thì dữ liệu mới được tổng hợp về hệ thống tích điểm.
Trả lời : Nếu giao dịch được tổng hợp từ hệ thống khác em nghĩ nên viết tiến trình. Tiến trình này được cấu hình chạy liên tục giãn cách theo config.


                                        ********************************************
Để tăng hiệu năng hệ thống khi có rất nhiều giao dịch của nhiều khách hàng đồng thời thì có giải pháp nào không?

Trả lời : Chúng ta sẽ đánh index cho trường id thẻ thích điểm là được. Lúc gọi dữ liệu để tính sẽ nhanh hơn.
          Hoặc chúng ta có thể tạo thêm 1 bảng để lưu lại lịch sử chưa được xử lý cũng là một cách
                                        ********************************************
                                                  Mô tả nghiệp vụ
- Khi người dùng đăng nhập và giao dịch từ Client truyền về được Mã Thẻ của khách hàng đó và Doanh Thu có thể hiểu là số tiền.
- Từ dó ta lấy được THÔNG TIN THẺ TÍCH ĐIỂM và HẠNG THẺ
- Trước đó ta đã lấy được CONFIG ( cấu hình ) dùng để đổi điểm
     + Chỗ này hơi khó hiểu vì nếu config thể này sẽ có rất nhiều bản ghi. ==> VÍ DỤ : số doanh thu là 10000000 
          dựa vào giá trị doanh thu của client truyền xuống, sau đó check config để quy ra điểm điều chỉnh ==> thì nếu đơn giản nếu khách hàng có số doanh thu không có trong cấu hình thì sẽ lỗi. 
     + Giai pháp cá nhân : Nếu số doanh thu không có trong cấu hình đồng thời phải insert config cho cấu hình để có thể quy đổi ra điểm.
- Sau đó tính được điểm và doanh thu thì lưu vào GIAO DICH TÍCH ĐIỂM ( hay còn gọi là lịch sử giao dịch) và cập nhật thông tin cho hạng thẻ và thẻ tích điểm. 
- Đang mặc định là 3 rank là Đồng, Bạc, và Vàng
100 điểm có thể lên bạc và 200 điểm có thể lên vàng. 
Từ đây có thể dựa vào cập nhật thông tin cho hạng thẻ của THẺ TÍCH ĐIỂM và số điểm cần để lên rank cho HẠNG THẺ
