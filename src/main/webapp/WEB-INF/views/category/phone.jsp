<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
	<div class="col-sm-2">
		<label>产品属性:</label>
	</div>
	<div class="col-sm-10">
		<div class="well base-attr">
			<table class="table table-condensed">
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
							<select class="selectpicker" data-live-search="true">
								<option data-subtext="French's">Mustard</option>
								<option data-subtext="French's">Ketchup</option>
								<option data-subtext="French's">Barbecue</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="attr-name">
							手机存储（手机硬盘）
						</td>
						<td class="attr-value">
							<select class="selectpicker" data-live-search="true">
								<option>2G</option>
								<option>3G</option>
								<option>4G</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="attr-name">
							手机内存
						</td>
						<td class="attr-value">
							<select class="selectpicker" data-live-search="true">
								<option>2G</option>
								<option>3G</option>
								<option>4G</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="attr-name">
							手机中央处理器
						</td>
						<td class="attr-value">
							<select class="selectpicker" data-live-search="true">
								<option>single core</option>
								<option>dual core</option>
								<option>quad core</option>
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
						</td>
					</tr>
				</tbody>
			</table>
			<hr class="soften">
			<div class="custom-attr">
				<a href="javascript:void(0)">添加自定义属性</a>
			</div>
		</div>
	</div>
</div>

<link href="<c:url value="/resources/bootstrap-select/css/bootstrap-select.min.css" />"
	rel="stylesheet"  type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/bootstrap-select/js/bootstrap-select.min.js" />"></script>