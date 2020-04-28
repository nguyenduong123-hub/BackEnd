 ******** Tuỳ chọn trả lời một số câu hỏi bổ sung sau ***********

Nếu giao dịch được tổng hợp từ các hệ thống khác và định kỳ được tải lên hệ thống tích điểm, thì xử lý như thế nào trong trường hợp cấu hình quy đổi điểm bị thay đổi giữa các lần giao dịch của khách hàng.
VD: Khách hàng có 3 giao dịch mua hàng vào buổi sáng, và 2 giao dịch vào buổi chiều cùng ngày. Cấu hình quy đổi điểm được thay đổi vào 12h trưa ngày hôm đó. 22h cuối ngày thì dữ liệu mới được tổng hợp về hệ thống tích điểm.
Trả lời : Nếu giao dịch được tổng hợp từ hệ thống khác em nghĩ nên viết tiến trình. Tiến trình này được cấu hình chạy liên tục giãn cách theo config.


********************************************
Để tăng hiệu năng hệ thống khi có rất nhiều giao dịch của nhiều khách hàng đồng thời thì có giải pháp nào không?

Trả lời : Chúng ta sẽ đánh index cho trường id thẻ thích điểm là được. Lúc gọi dữ liệu để tính sẽ nhanh hơn.
          Hoặc chúng ta có thể tạo thêm 1 bảng để lưu lại lịch sử chưa được xử lý cũng là một cách
