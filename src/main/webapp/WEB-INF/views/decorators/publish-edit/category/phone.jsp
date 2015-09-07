<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<body>
	
	<div class="row">
		<div class="col-sm-2">
			<label>产品属性:</label>
		</div>
		<div class="col-sm-10">
			<div class="well base-attr">
				<table id="product-attr-table" class="table table-condensed">
					<tbody>
						<tr>
							<td class="attr-name">
								是否是无锁电话
							</td>
							<td class="attr-value">
								Yes
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								品牌
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Acer(宏碁)</option>
									<option>ACT(安科讯)</option>
									<option>AiBeiDuo(爱贝多)</option>
									<option>Aigo(爱国者)</option>
									<option>aiyitong(aiyitong)</option>
									<option>AiYiTong(爱易通)</option>
									<option>Alcatel(阿尔卡特)</option>
									<option>Alfa(阿尔发)</option>
									<option>altek(altek)</option>
									<option>Amoi(Amoi)</option>
									<option>Amsam(艾美讯)</option>
									<option>AOLE(AOLE/奥乐)</option>
									<option>APPLE(苹果)</option>
									<option>Arcci / elegant device(Arcci/雅器)</option>
									<option>Asus(华硕)</option>
									<option>AUX(奥克斯)</option>
									<option>AWIT(AWIT)</option>
									<option>BaiZhao(百兆)</option>
									<option>bambook(bambook)</option>
									<option>BaoXing(宝星)</option>
									<option>BARBIE(芭比(需要提供正品证明))</option>
									<option>Basicom(宝捷讯)</option>
									<option>BBK(步步高)</option>
									<option>BDBAL(百迪宝)</option>
									<option>BEDOVE(BEDOVE)</option>
									<option>bee / bee(bee/小蜜蜂)</option>
									<option>BeiDou(北斗)</option>
									<option>Benq(明基(需要提供正品证明))</option>
									<option>BenQ-SIEMENS(明基西门子)</option>
									<option>bicix / Bai matter Communications(bicix/佰事讯)</option>
									<option>BIFER(贝尔丰)</option>
									<option>BIRD(波导)</option>
									<option>Blackberry(Blackberry)</option>
									<option>Bluboo(Bluboo)</option>
									<option>Bluebo(蓝天信)</option>
									<option>BOMY(邦华)</option>
									<option>Callbar(Callbar)</option>
									<option>Capitel(首信)</option>
									<option>Casio(卡西欧)</option>
									<option>CAYON(嘉源)</option>
									<option>CECT(中电华通)</option>
									<option>CELLUTEL(赛洛特)</option>
									<option>Changhong(长虹)</option>
									<option>CHEER(亿城)</option>
									<option>ChengJi(诚基)</option>
									<option>ChenXing(晨兴)</option>
									<option>CHER(齐乐)</option>
									<option>CHINA BRIDGE(中宝)</option>
									<option>China Mobile(中国移动)</option>
									<option>COMNEED(康力)</option>
									<option>CONOR(酷诺)</option>
									<option>Coolpad(Coolpad)</option>
									<option>COSUN(侨兴)</option>
									<option>CSN(CSN/创世能)</option>
									<option>Cubot(Cubot)</option>
									<option>Dapeng(Dapeng)</option>
									<option>DaTang(大唐)</option>
									<option>Daxian(大显)</option>
									<option>DEC(中恒)</option>
									<option>Ded(new)(桑达（新）)</option>
									<option>DELL(戴尔)</option>
									<option>Deovo(Deovo)</option>
									<option>Desay(德赛)</option>
									<option>DieYing(蝶影)</option>
									<option>Disney(迪士尼)</option>
									<option>DOMOD(多美达)</option>
									<option>Doogee(Doogee)</option>
									<option>DOOV(朵唯)</option>
									<option>Dopod(多普达(需要提供正品证明))</option>
									<option>DuBao(都宝)</option>
									<option>EASTCOM(东信)</option>
									<option>EBL(EBL)</option>
									<option>Elephone(Elephone)</option>
									<option>elitek(埃立特)</option>
									<option>EPHONE(易丰)</option>
									<option>Ericsson(爱立信)</option>
									<option>Eten(倚天)</option>
									<option>ETON(亿通)</option>
									<option>EXUN(南极星)</option>
									<option>Fadar(锋达通)</option>
									<option>Feiteng(Feiteng)</option>
									<option>FeiTianLong(飞天龙)</option>
									<option>FeiYang(飞洋)</option>
									<option>FengBao(锋宝)</option>
									<option>FORY(福日)</option>
									<option>Fujitsu(富士通)</option>
									<option>G'HONG(G’HONG)</option>
									<option>G'HONG(G‘HONG/国虹)</option>
									<option>Gaoke(高科)</option>
									<option>GaoXinQi(高新奇)</option>
									<option>Garnish(嘉信)</option>
									<option>Gerber(嘉宝(需要提供正品证明))</option>
									<option>Gfive(Gfive)</option>
									<option>Gigabyte(技嘉)</option>
									<option>Gionee(金立)</option>
									<option>Gnet(GNET)</option>
									<option>Google(谷歌)</option>
									<option>GOSPELL(高斯贝尔)</option>
									<option>GREAT(GREAT)</option>
									<option>Green Orange(青橙)</option>
									<option>GT(GT)</option>
									<option>GuoQian(国乾科技)</option>
									<option>Guoxin(国信)</option>
									<option>Haier(海尔)</option>
									<option>Haipai(Haipai)</option>
									<option>HanTel(汉泰)</option>
									<option>HDC(华信)</option>
									<option>Hedy(七喜)</option>
									<option>Hero(Hero)</option>
									<option>HI-Tech(恒基伟业)</option>
									<option>Hike / Hacker(Hike/海客)</option>
									<option>Hisense(Hisense)</option>
									<option>HKC(惠科)</option>
									<option>HONCON(宏康)</option>
									<option>HOSIN(欧新)</option>
									<option>HP(惠普)</option>
									<option>HTC(HTC)</option>
									<option>HuaLi(华立)</option>
									<option>HuaLu(华录)</option>
									<option>Huawei(Huawei)</option>
									<option>HUAYU(盛泰华禹)</option>
									<option>HuTong(互通)</option>
									<option>HYUNDAI(现代(需要提供正品证明))</option>
									<option>i-mate(i-mate)</option>
									<option>IDO(爱度)</option>
									<option>Ihkc(弘谷电)</option>
									<option>iNEW(iNEW)</option>
									<option>Infocus(富可视)</option>
									<option>INNOS(INNOS)</option>
									<option>intki(intki/英特奇)</option>
									<option>iOCEAN(iOCEAN欧盛)</option>
									<option>ISA(ISA)</option>
									<option>iuni(iuni)</option>
									<option>Jeepont / Jibang(Jeepont/吉邦)</option>
									<option>Jiayu(Jiayu)</option>
									<option>JinPeng(金鹏)</option>
									<option>Jugate(知己)</option>
									<option>JXD(金星)</option>
									<option>K-Touch(K-Touch)</option>
									<option>KeDa(科达)</option>
									<option>Kenuo(科诺)</option>
									<option>KINGSUN(广信)</option>
									<option>KliTON(KliTON/凯利通)</option>
									<option>Komi(Komi)</option>
									<option>KONKA(康佳)</option>
									<option>koobee(koobee)</option>
									<option>KPT(港利通)</option>
									<option>KUBAO(KUBAO/酷宝)</option>
									<option>Kyocera(京瓷)</option>
									<option>LAMTAM(蓝天)</option>
									<option>LangXing(朗星)</option>
									<option>Lanwea / Union peacekeeping(Lanwea/联维)</option>
									<option>Lenovo(Lenovo)</option>
									<option>LEPHONE(立丰)</option>
									<option>LEXUE(LEXUE)</option>
									<option>LG(LG)</option>
									<option>LianChuang(联创)</option>
									<option>LingKe(凌科)</option>
									<option>Lingwin(聆韵)</option>
									<option>Logo(朗格)</option>
									<option>LOVME(LOVME)</option>
									<option>LvLi(绿力)</option>
									<option>M.ReN(铭仁)</option>
									<option>Malata(万利达)</option>
									<option>Mastone(万事通)</option>
									<option>MeiLing(美菱)</option>
									<option>Meitu(Meitu/美图)</option>
									<option>Meizu(魅族)</option>
									<option>MengBao(盟宝)</option>
									<option>MIGO(MIGO)</option>
									<option>Mio(宇达电通)</option>
									<option>Mitsubishi Electric(三菱)</option>
									<option>MOFUT(MOFUT/美富通)</option>
									<option>Motorola(Motorola)</option>
									<option>Move the circle / Mai peak(移动圈圈/麦峰)</option>
									<option>MoXing(摩星)</option>
									<option>NAMO(NAMO)</option>
									<option>NCBC(新中桥)</option>
									<option>NEC(NEC(需要提供正品证明))</option>
									<option>Neken(尼凯恩)</option>
									<option>NEO(NEO)</option>
									<option>Newman(Newman)</option>
									<option>Newsmy(Newsmy/纽曼)</option>
									<option>Nokia(Nokia)</option>
									<option>nubia / Nubia(nubia/努比亚)</option>
									<option>O2(O2)</option>
									<option>OBEE(振华欧比)</option>
									<option>OINOM(乐目)</option>
									<option>OKWAP(英华OK)</option>
									<option>Oneplus(1加)</option>
									<option>ONN(欧恩)</option>
									<option>OPP(OPP)</option>
									<option>OPPO(OPPO)</option>
									<option>OQO(OQO)</option>
									<option>OUKI(OUKI/欧奇)</option>
									<option>OuXin(欧信)</option>
									<option>Palm(奔迈(需要提供正品证明))</option>
									<option>Panasonic(松下)</option>
									<option>Panda(熊猫)</option>
									<option>Pantech(泛泰)</option>
									<option>PHICOMM(斐讯)</option>
									<option>PHILIPS(PHILIPS)</option>
									<option>POMP(盛况)</option>
									<option>PULID(普莱达)</option>
									<option>Purple UNIS(紫光UNIS)</option>
									<option>PuTian(普天)</option>
									<option>QianNa(千纳)</option>
									<option>QIGI(琦基)</option>
									<option>Qing Yang(青漾)</option>
									<option>Rahotech(锐合通信)</option>
									<option>Royalstar(荣事达)</option>
									<option>Samsung(Samsung)</option>
									<option>SangDa(桑达)</option>
									<option>SanKe(三科)</option>
									<option>SanMeng(三盟)</option>
									<option>SANYO(三洋)</option>
									<option>SDO(盛大)</option>
									<option>SHARP(夏普(需要提供正品证明))</option>
									<option>ShengTai(盛泰)</option>
									<option>ShouXiang(首相)</option>
									<option>SIEMENS(西门子(需要提供正品证明))</option>
									<option>SK(SK)</option>
									<option>Skyworth(创维)</option>
									<option>Soaiy(索爱)</option>
									<option>Soaye(Soaye)</option>
									<option>SongXunDa(松讯达)</option>
									<option>Sonim(萨基姆)</option>
									<option>Sony(Sony)</option>
									<option>Sony Ericsson(索尼爱立信)</option>
									<option>SOP(SOP)</option>
									<option>SSX(关爱行)</option>
									<option>Star(Star)</option>
									<option>Sunlight(盛隆)</option>
									<option>SUNUP(SUNUP/三普)</option>
									<option>T-Smart(T-Smart)</option>
									<option>TaiXun(泰讯)</option>
									<option>Taobao(淘宝手机)</option>
									<option>Tatop / products to(Tatop/品至)</option>
									<option>TCL(TCL)</option>
									<option>TeLingTong(特灵通)</option>
									<option>Telsda(天时达)</option>
									<option>Tenyale(天宇)</option>
									<option>TenYu(腾宇)</option>
									<option>THL(THL)</option>
									<option>TianLong(天珑)</option>
									<option>TianYuan(天元)</option>
									<option>TONAINE(TONAINE/途耐)</option>
									<option>TOOKY(京崎)</option>
									<option>Toshiba(东芝)</option>
									<option>TSD(腾盛达)</option>
									<option>U9(U9)</option>
									<option>UBTEL(UBTEL)</option>
									<option>UKING(UKING)</option>
									<option>Umeox(Umeox)</option>
									<option>Umi(Umi)</option>
									<option>UMO(优摩)</option>
									<option>Uniscom(紫光电子)</option>
									<option>UniscopE(优思)</option>
									<option>UniStar(友信达)</option>
									<option>UNITONE(友利通)</option>
									<option>UT Starcom(UT斯达康)</option>
									<option>Utime(联合时代)</option>
									<option>UU(UU)</option>
									<option>V Land(葳朗)</option>
									<option>V-HOPE / Wei Platinum(V-HOPE/威铂)</option>
									<option>Vcall(唯科)</option>
									<option>VEVA(VEVA)</option>
									<option>VIM(VIM)</option>
									<option>Vinus(Vinus)</option>
									<option>VITA(华唐)</option>
									<option>vivo(vivo)</option>
									<option>VIZIO(VIZIO)</option>
									<option>VK(唯开)</option>
									<option>VOAO(唯奥)</option>
									<option>VOTO(VOTO)</option>
									<option>vowney(凡尔纳)</option>
									<option>Wandeli(万得利)</option>
									<option>Widetel(汇讯)</option>
									<option>WISHWAY(WISHWAY/西维)</option>
									<option>Xiaomi(Xiaomi)</option>
									<option>XinXiangSui(心相随)</option>
									<option>xrangl(xrangl/好响亮)</option>
									<option>Xtelecom(爱肯)</option>
									<option>YAS(YAS)</option>
									<option>YaXing(雅星)</option>
									<option>YaXunDa(雅讯达)</option>
									<option>YiHeYuan(亿和源)</option>
									<option>YingXun(盈讯)</option>
									<option>YITON(YITON/亿通)</option>
									<option>yunjian(韵健)</option>
									<option>Yusun(语信)</option>
									<option>ZAXID(兆讯达)</option>
									<option>ZhongTian(中天)</option>
									<option>ZhongYi(众一)</option>
									<option>zopo(zopo)</option>
									<option>ZTE(ZTE)</option>
									<option>Other(其它)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								手机存储（手机硬盘）
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>&lt;2G(小于2G)</option>
									<option>2G(2G)</option>
									<option>4G(4G)</option>
									<option>8G(8G)</option>
									<option>16G(16G)</option>
									<option>32G(32G)</option>
									<option>64G(64G)</option>
									<option>&gt;64G(64G以上)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								手机内存
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>&lt;128M(小于128M)</option>
									<option>128M(128M)</option>
									<option>256M(256M)</option>
									<option>512M(512M)</option>
									<option>1G(1G)</option>
									<option>2G(2G)</option>
									<option>4G(4G)</option>
									<option>1.5G(1.5G)</option>
									<option>768M(768M)</option>
									<option>3G(3G)</option>
									<option>Other(其它)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								手机中央处理器
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Single Core(单核)</option>
									<option>Dual Core(双核)</option>
									<option>Quad Core(四核)</option>
									<option>Quad+Quad Core(四+四核)</option>
									<option>Octa Core(八核)</option>
									<option>Hexa Core(六核)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								外观样式
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Bar(直板机)</option>
									<option>Flip(翻盖机)</option>
									<option>Rotatable(旋转机)</option>
									<option>Slider(滑盖机)</option>
									<option>Watch(手表手机)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								产品成色
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>New(全新)</option>
									<option>Used(二手)</option>
									<option>Refurbished(翻新)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								操作系统
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Android(Android)</option>
									<option>Linux(Linux)</option>
									<option>Symbian(Symbian)</option>
									<option>Windows Mobile(Windows Mobile)</option>
									<option>No Smartphone(非智能手机)</option>
									<option>Palm(Palm)</option>
									<option>BlackBerry(BlackBerry)</option>
									<option>iOS(iOS)</option>
									<option>OMS(OMS)</option>
									<option>meego(meego)</option>
									<option>Aliyun(Aliyun)</option>
									<option>rex(rex)</option>
									<option>Nucleus(Nucleus)</option>
									<option>INFINEON(INFINEON)</option>
									<option>Others(其它)</option>
									<option>mmp(mmp)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								移动通讯技术
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>GSM(GSM)</option>
									<option>CDMA(CDMA)</option>
									<option>WCDMA(WCDMA)</option>
									<option>CDMA2000(CDMA2000)</option>
									<option>LTE(LTE)</option>
									<option>GSM/CDMA(GSM/CDMA)</option>
									<option>GSM/CDMA2000(GSM/CDMA2000)</option>
									<option>GSM/WCDMA/CDMA/CDMA2000(GSM/WCDMA/CDMA/CDMA2000)</option>
									<option>GSM/WCDMA/LTE(GSM/WCDMA/LTE)</option>
									<option>GSM/WCDMA(GSM/WCDMA)</option>
									<option>Others(其它)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								特性
							</td>
							<td class="attr-value">
								<label>
									<input type="checkbox">
									<span>GPS Navigation(GPS导航)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Email(邮件)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>FM Radio(FM收音机)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>MP3 Playback(MP3播放)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Touchscreen(触摸屏)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>QWERTY Keyboard(全键盘)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Bluetooth(蓝牙)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Wi-Fi(Wi-Fi)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Memory Card Slots(有记忆卡插槽)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Video Player(支持视频播放)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Gravity Response(支持重力感应)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Front Camera(视频通话摄像头)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>TV Receive(支持电视接收)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Dustproof(三防功能)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Message(短信)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>HD Video Player(高清视频播放)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>GPRS(GPRS上网)</span>
								</label>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								CPU品牌
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>MTK(联发科)</option>
									<option>Qualcomm(高通)</option>
									<option>Texas Instruments(德州仪器)</option>
									<option>Nvidia(英伟达)</option>
									<option>Samsung(三星)</option>
									<option>Huawei(华为)</option>
									<option>Marvell(迈威)</option>
									<option>Intel(英特尔)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								屏幕尺寸
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>1.8(1.8英寸)</option>
									<option>2.0(2.0英寸)</option>
									<option>2.2(2.2英寸)</option>
									<option>2.4(2.4英寸)</option>
									<option>2.8(2.8英寸)</option>
									<option>3.0(3.0英寸)</option>
									<option>3.2(3.2英寸)</option>
									<option>3.5(3.5英寸)</option>
									<option>3.7(3.7英寸)</option>
									<option>4.0(4.0英寸)</option>
									<option>4.2(4.2英寸)</option>
									<option>4.3(4.3英寸)</option>
									<option>4.5(4.5英寸)</option>
									<option>4.6(4.6英寸)</option>
									<option>4.7(4.7英寸)</option>
									<option>4.8(4.8英寸)</option>
									<option>5.0(5.0英寸)</option>
									<option>5.3(5.3英寸)</option>
									<option>5.5(5.5英寸)</option>
									<option>7.0(7.0英寸)</option>
									<option>7.7(7.7英寸)</option>
									<option>6.1(6.1英寸)</option>
									<option>5.7(5.7英寸)</option>
									<option>6.0(6.0英寸)</option>
									<option>6.3(6.3英寸)</option>
									<option>3.1(3.1英寸)</option>
									<option>3.3(3.3英寸)</option>
									<option>3.4(3.4英寸)</option>
									<option>3.6(3.6英寸)</option>
									<option>3.8(3.8英寸)</option>
									<option>4.4(4.4英寸)</option>
									<option>5.9(5.9英寸)</option>
									<option>5.1(5.1英寸)</option>
									<option>5.2(5.2英寸)</option>
									<option>6.5(6.5英寸)</option>
									<option>Other(其它)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								屏幕颜色
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Black / White(黑白屏)</option>
									<option>Color(彩屏)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								系统语言
							</td>
							<td class="attr-value">
								<label>
									<input type="checkbox">
									<span>English(英语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Russian(俄语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>German(德语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>French(法语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Spanish(西班牙语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Polish(波兰语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Portuguese(葡萄牙语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Italian(意大利语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Turkish(土耳其语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Norwegian(挪威语)</span>
								</label>
								<label>
									<input type="checkbox">
									<span>Other(其它)</span>
								</label>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								视频拍摄画质
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>360P(360P)</option>
									<option>480I(480I)</option>
									<option>480P(480P)</option>
									<option>720P(720P)</option>
									<option>1080I(1080I)</option>
									<option>1080P(1080P)</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								厚度
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Ultra Slim(&lt;9mm)(超薄(小于9mm))</option>
									<option>Slim(9mm-10mm)(薄(9mm~10mm))</option>
									<option>Normal(&gt;10mm)(普通(大于10mm))</option>
								</select>
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								电池容量(mAh)
							</td>
							<td class="attr-value">
								<input type="text" size="20">
							</td>
						</tr>
						<tr>
							<td class="attr-name">
								支持多少SIM卡
							</td>
							<td class="attr-value">
								<select class="selectpicker" data-live-search="true" title='---请选择---'>
									<option>Single SIM Card(单卡单待)</option>
									<option>Dual SIM Cards(双卡双待)</option>
									<option>Three SIM Cards(三卡三待)</option>
									<option>Quad SIM Cards(四卡四待)</option>
								</select>
							</td>
						</tr>

					</tbody>
				</table>
				
				<hr class="dotten">

				<div class="custom-attr-div">
					<a href="javascript:void(0)" id="custom-attr-a">添加自定义属性</a>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	$("#custom-attr-a").click(function(){
		$(this).before("<div class='custom-attr-row'><span class='attr-name'><input type='text' size='30' placeholder='属性名 - 例如：Color'></span><span class='attr-value'><input type='text' size='30' placeholder='属性值 - 例如：Red'></span><a href='javascript:void(0)'>删除</a></div>");
		$(this).parent().find("div > a").off("click");
		$(this).parent().find("div > a").on("click", null, function(){
			$(this).parent().remove();
		});
	});
	</script>

</body>
</html>