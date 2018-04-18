<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="exampleInputEmail1">专利名称</label>
    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请填写专利">
</div>
<div class="form-group">
    <label>专利类型</label>
    <select class="form-control">
        <option>发明</option>
        <option>实用新型</option>
        <option>外型</option>
        <option>国际专利</option>
    </select>
</div>
<div class="form-group">
    <label>专利状态</label>
    <select class="form-control">
        <option>已授权</option>
        <option>已受理</option>
        <option>已申请</option>
    </select>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">专利编号</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="如xx">
</div>
<div class="form-group">
    <label>获得时间</label>

    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" id="datepicker">
    </div>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">申请编号</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="如xx">
</div>
<div class="form-group">
    <label>申请时间</label>

    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" id="datepicker1">
    </div>
</div>
<div class="form-group">
    <label for="exampleInputPassword1">本人编号</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="1">
</div>
<div class="form-group">
    <label for="exampleInputPassword1">关联课题</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="请输入关联课题">
</div>
<!-- textarea -->
<div class="form-group">
    <label>备注</label>
    <textarea class="form-control" rows="3" placeholder="请输入备注信息"></textarea>
</div>
