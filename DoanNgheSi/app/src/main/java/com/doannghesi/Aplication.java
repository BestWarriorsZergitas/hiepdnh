package com.doannghesi;

import android.app.Application;
import android.util.Log;

import com.doannghesi.objects.Singer;
import com.doannghesi.utils.DatabaseManager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Peih Gnaoh on 8/12/2017.
 */

public class Aplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);
        if (!DatabaseManager.INSTANCE.isHaveData()){
            Log.d("ádasdasd","đâsdas");
            addData();
        }
    }

    private void addData() {
        Singer singer1=new Singer("Bằng Kiều","BANGKIEU","Nam ca sĩ từng tham gia các ban nhạc Chìa khóa vàng, Hoa sữa, Quả dưa hấu và sau đó tách ra hát solo riêng.",R.raw.bangkieu);
        Singer singer2=new Singer("Bảo Anh","BAOANH","Cô được biết đến lần đầu khi tham gia chương trình Giọng hát Việt mùa đầu tiên năm 2012",R.raw.baoanh);
        Singer singer3=new Singer("Bích Phương","BICHPHUONG","Được mệnh danh là \"Thánh nữ nhạc sầu\".",R.raw.bichphuong);
        Singer singer4=new Singer("Bùi Anh Tuấn","BUIANHTUAN","Anh thật sự trở thành một hiện tượng khi anh tham gia cuộc thi Giọng hát Việt năm 2012. Tại vòng giấu mặt, anh đã thể hiện rất thành công ca khúc “Nơi tình yêu bắt đầu”.",R.raw.buianhtuan);
        Singer singer5=new Singer("Cẩm Ly","CAMLY","Cô được các fan hâm mộ gọi là Chị Tư",R.raw.camly);
        Singer singer50=new Singer("Cao Thái Sơn","CAOTHAISON","Cuối năm 2009 Anh lần đầu tiên nhận giải một trong 10 ca sĩ được yêu thích nhất của bảng xếp hạng Làn Sóng Xanh 2009 với những ca khúc như: Con đường mưa, pha lê tím...",R.raw.caothaison);
        Singer singer6=new Singer("Chế Linh","CHELINH","Là ca sĩ người Chăm nổi tiếng, đồng thời là nhạc sĩ tài hoa với bút hiệu Tú Nhi và Lưu Trần Lê. ",R.raw.chelinh);
        Singer singer7=new Singer("Chi Dân","CHIDAN","Ca sĩ bất ngờ nổi tiếng sau ca khúc Mất Trí Nhớ",R.raw.chidan);
        Singer singer8=new Singer("Đàm Vĩnh Hưng","DAMVINHHUNG","Là một trong những ca sĩ có cát-xê cao nhất Việt Nam",R.raw.damvinhhung);
        Singer singer9=new Singer("Đan Nguyên","DANNGUYEN","Là một ca sĩ hải ngoại thành công với dòng nhạc trữ tình trước năm 1975",R.raw.dannguyen);
        Singer singer10=new Singer("Đan Trường","DANTRUONG","Là một nam ca sĩ nổi tiếng người Việt Nam xuất hiện vào những năm cuối thập niên 90, được mệnh danh là Hoàng tử V-Pop thế hệ đầu tiên của làng nhạc Việt.",R.raw.dantruong);
        Singer singer11=new Singer("Đông Nhi","DONGNHI","Cô được biết đến với một số ca khúc hit dành cho lứa tuổi teen như: “Khóc”, “Bối Rối”, “Bí Mật Của Hạnh Phúc”, “Lời Thú Tội Ngọt Ngào”,.. ",R.raw.dongnhi);
        Singer singer12=new Singer("Duy Mạnh","DUYMANH","Là ca sĩ thành công sau các bài hát do chính anh sáng tác như: Hãy về đây bên anh, Kiếp đỏ đen, Ta đâu có say, Tình em là đại dương, Biết tìm đâu, Dĩ vãng cuộc tình, Lời xin lỗi của một dân chơi.",R.raw.duymanh);
        Singer singer13=new Singer("ERIK","ERIK","Là một ca sĩ Việt Nam xuất thân là cựu thành viên nhóm nhạc Monstar.",R.raw.erik);
        Singer singer14=new Singer("Hà Anh Tuấn","HAANHTUAN","Là một nam ca sĩ nhạc R&B người Việt Nam. Anh bắt đầu nổi tiếng từ khi lọt vào top 3 cuộc thi Sao Mai điểm hẹn năm 2006.",R.raw.haanhtuan);
        Singer singer15=new Singer("Hariwon","HARIWON","Cắm sừng Tiến Đạt :D",R.raw.hariwon);
        Singer singer16=new Singer("Hoài Lâm","HOAILAM","Con nuôi Hoài Linh",R.raw.hoailam);
        Singer singer17=new Singer("Hòa Minzy","HOAMINZY","Cô từng đoạt giải quán quân Học viện Ngôi sao 2014",R.raw.hoaminzy);
        Singer singer18=new Singer("Hồ Hoài Anh","HOHOAIANH","Huấn luyện viên cuộc thi Giọng hát Việt nhí mùa 1, mùa 2, mùa 3",R.raw.hohoaianh);
        Singer singer19=new Singer("Hồ Ngọc Hà","HONGOCHA","Ngoài sự nghiệp ca hát, cô còn tham gia diễn xuất với ba bộ phim truyền hình là Hoa cỏ may, 39 độ yêu và Chiến dịch trái tim bên phải.",R.raw.hongocha);
        Singer singer20=new Singer("Hồ Quang Hiếu","HOQUANGHIEU","Bắt đầu thành công sau khi phát hành ca khúc cùng tên trong album \"Chỉ cần em hạnh phúc\"",R.raw.hoquanghieu);
        Singer singer21=new Singer("Hồ Vĩnh Khoa","HOVINHKHOA","Diễn viên trong phim Hotboy nổi loạn.",R.raw.hovinhkhoa);
        Singer singer22=new Singer("Hương Tràm","HUONGTRAM","Quán quân của Giọng hát Việt 2012",R.raw.huongtram);
        Singer singer23=new Singer("Isaac","ISAAC","Trưởng nhóm nhạc 365",R.raw.isaac);
        Singer singer24=new Singer("Khắc Việt","KHACVIET","ra mắt ca khúc đầu tay với tựa đề \"Quên\" vào năm 2009.\n" +
                "\n" +
                "Đầu năm 2010, album single \"Như vậy nhé\" được phát hành online.",R.raw.khacviet);
        Singer singer25=new Singer("Lam Trường","LAMTRUONG","thường được người hâm mộ gọi thân mật là \"Anh Hai\" và thường viết là \"A2\".",R.raw.lamtruong);
        Singer singer26=new Singer("Lou Hoàng","LOUHOANG","Anh là một ca sĩ, là học trò của nam ca sĩ Only C.Từng xuất hiện trong cuộc thi \"Ngôi sao Việt\"",R.raw.louhoang);
        Singer singer27=new Singer("Lương Bằng Quang","LUONGBANGQUANG","Là nhạc sĩ trẻ nhất nhận giải Làn sóng xanh 2004 với bài hit Đôi chân thiên thần ",R.raw.luongbangquang);
        Singer singer28=new Singer("Minh Hằng","MINHHANG","Ra mắt album đầu tay của mình mang tên Một vòng Trái Đất",R.raw.minhhang);
        Singer singer29=new Singer("Minh Quân","MINHQUAN","Anh từng là giám khảo chương trình Thần tượng âm nhạc: Vietnam Idol (mùa 5) (2014).",R.raw.minhquan);
        Singer singer30=new Singer("Mr Siro","MRSIRO","Tác giả siêu phẩm Lắng nghe nước mắt",R.raw.mrsiro);
        Singer singer31=new Singer("Mỹ Linh","MYLINH","Cô là một trong bốn giọng ca được công nhận là diva Việt Nam ",R.raw.mylinh);
        Singer singer32=new Singer("Noo Phước Thịnh","NOOPHUOCTHINH","Anh là quán quân của The Remix (Hòa âm ánh sáng) mùa thứ 2 (2016)",R.raw.noophuocthinh);
        Singer singer33=new Singer("Ông Cao Thắng","ONGCAOTHANG","",R.raw.ongcaothang);
        Singer singer34=new Singer("Only C","ONLYC"," Dự án đầu tiên của anh là sản xuất và sáng tác cho album Try To Up của Khổng Tú Quỳnh.",R.raw.onlyc);
        Singer singer35=new Singer("Phan Mạnh Quỳnh","PHANMANHQUYNH","Phát hành album Vợ người ta và thành công lớn với ca khúc chủ đề cùng tên đã trở thành một hiện tượng trong năm 2015",R.raw.phanmanhquynh);
        Singer singer36=new Singer("Phi Nhung","PHINHUNG","Được người trong giới và khán giả đặt cho nghệ danh ''nữ hoàng băng dĩa''.",R.raw.phinhung);
        Singer singer37=new Singer("Quang Vinh","QUANGVINH","Một biệt danh khá dễ thương khán giả nhí đã dành tặng riêng để gọi anh: chàng Hoàng tử Sơn Ca.",R.raw.quangvinh);
        Singer singer38=new Singer("Rhymastic","RHYMASTIC","Anh chính thức bước chân vào sự nghiệp âm nhạc chuyên nghiệp, với tư cách là một rapper, nhà sản xuất âm nhạc của Space Speakers.",R.raw.rhymastic);
        Singer singer39=new Singer("Sơn Tùng","SONTUNG","Trưởng thành từ nhạc underground, Anh bị \"nghi ngờ\" đạo nhạc nhiều lần. Các ca khúc của anh được cho là đã lấy phần beat (nhạc nền) từ các bài hát nổi tiếng ở Hàn Quốc, Nhật Bản hay Mỹ.",R.raw.sontung);
        Singer singer40=new Singer("Soobin Hoàng Sơn","SOOBINHOANGSON","Đạt giải bạc tại chương trình Hòa âm ánh sáng 2016",R.raw.soobinhoangson);
        Singer singer41=new Singer("Thu Minh","THUMINH","Bước ngoặt lớn nhất trong sự nghiệp âm nhạc của cô là sự thành công của những bài hát như Nhớ anh, album \"Thiên Đàng\" với Chuông gió, Bóng mây qua thềm, Mong anh về và sau này Đường cong, Bay, Taxi, Xinh trong album \"Body Language\" đã tiên phong mở đường cho trào lưu nhạc dance chuyên nghiệp tại Việt Nam.",R.raw.thuminh);
        Singer singer42=new Singer("Thủy Tiên","THUYTIEN","Khởi đầu sự nghiệp âm nhạc chuyên nghiệp qua album CD của nhạc sĩ Quốc Bảo mang tên \"Tales - Những chuyện kể\" với 2 ca khúc \"Tình em\" và \"Ta đã yêu trong mùa gió\"",R.raw.thuytien);
        Singer singer43=new Singer("Tiên Tiên","TIENTIEN","Cô từng là thí sinh của chương trình Giọng hát Việt mùa thứ hai trong đội nhạc sĩ Quốc Trung, khi đó cô lấy tên là Thủy Tiên.",R.raw.tientien);
        Singer singer44=new Singer("Tim","TIM","Anh đã trình bày rất thành công nhiều ca khúc cho giới trẻ như: “Một vòng Trái Đất”, “8 vạn 6 ngàn 4 trăm lần nhớ em”, “Cánh chim hải âu”, “Món quà vô giá”.",R.raw.tim);
        Singer singer45=new Singer("Tóc Tiên","TOCTIEN","Cô giành được nhiều cơ hội lớn trong sự nghiệp ca hát của mình từ khi còn là niên thiếu, như: được góp mặt trong đoàn diễn xuyên Việt của nhạc sĩ Thế Hiển, tham gia ban nhạc Yo! Band",R.raw.toctien);
        Singer singer46=new Singer("Trịnh Thăng Bình","TRINHTHANGBINH","nam ca sĩ phát hành album thứ hai \"Summer love\" với nhiều hit được bạn trẻ yêu mến như: Lời chưa nói, Đã biết sẽ có ngày hôm qua, Đã lâu không gặp...",R.raw.trinhthangbinh);
        Singer singer47=new Singer("Tuấn Ngọc","TUANNGOC","Được nhiều người xem như một giọng ca nam \"tượng đài\" của nền tân nhạc Việt Nam.",R.raw.tuanngoc);
        Singer singer48=new Singer("Ưng Hoàng Phúc","UNGHOANGPHUC","Anh từng là cựu thành viên của nhóm 1088, một ban nhạc nam nổi tiếng của Nhạc trẻ Việt Nam",R.raw.unghoangphuc);
        Singer singer49=new Singer("Vũ Cát Tường","VUCATTUONG","Cô là huấn luyện viên của chương trình Giọng Hát Việt Nhí mùa thứ 4",R.raw.vucattuong);

        ArrayList<Singer> singers=new ArrayList<>();
        singers.add(singer1);
        singers.add(singer2);
        singers.add(singer3);
        singers.add(singer4);
        singers.add(singer5);
        singers.add(singer6);
        singers.add(singer7);
        singers.add(singer8);
        singers.add(singer9);
        singers.add(singer10);
        singers.add(singer11);
        singers.add(singer12);
        singers.add(singer13);
        singers.add(singer14);
        singers.add(singer15);
        singers.add(singer16);
        singers.add(singer17);
        singers.add(singer18);
        singers.add(singer19);
        singers.add(singer20);
        singers.add(singer21);
        singers.add(singer22);
        singers.add(singer23);
        singers.add(singer24);
        singers.add(singer25);
        singers.add(singer26);
        singers.add(singer27);
        singers.add(singer28);
        singers.add(singer29);
        singers.add(singer30);
        singers.add(singer31);
        singers.add(singer32);
        singers.add(singer33);
        singers.add(singer34);
        singers.add(singer35);
        singers.add(singer36);
        singers.add(singer37);
        singers.add(singer38);
        singers.add(singer39);
        singers.add(singer40);
        singers.add(singer41);
        singers.add(singer42);
        singers.add(singer43);
        singers.add(singer44);
        singers.add(singer45);
        singers.add(singer46);
        singers.add(singer47);
        singers.add(singer48);
        singers.add(singer49);
        singers.add(singer50);
        Collections.shuffle(singers);

        for (int i=0;i<singers.size();i++){
            DatabaseManager.INSTANCE.addSingerToDB(singers.get(i));
        }
    }
}
