<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="patentName">专利名称</label>
    <input type="text" class="form-control" name="patentName" id="patentName" placeholder="请填写专利">
</div>
<div class="form-group">
    <label>专利类型</label>
    <select class="form-control" name="patentType">
        <option value="发明" selected="selected">发明</option>
        <option value="实用新型">实用新型</option>
        <option value="外型">外型</option>
        <option value="国际专利">国际专利</option>
    </select>
</div>
<div class="form-group">
    <label>专利状态</label>
    <select class="form-control" name="patentStatus">
        <option value="已授权" selected="selected">已授权</option>
        <option value="已受理">已受理</option>
        <option value="已申请">已申请</option>
    </select>
</div>
<div class="form-group">
    <label for="patentCode">专利编号</label>
    <input type="text" class="form-control" name="patentCode" id="patentCode" placeholder="如xx">
</div>
<div class="form-group">
    <label>获得时间</label>

    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="getPatentDate" id="getPatentDate">
    </div>
</div>
<div class="form-group">
    <label for="applyCode">申请编号</label>
    <input type="text" class="form-control" name="applyCode" id="applyCode" placeholder="如xx">
</div>
<div class="form-group">
    <label>申请时间</label>

    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="applyDate" id="applyDate">
    </div>
</div>
<div class="form-group">
    <label for="selfRank">本人编号</label>
    <input type="text" class="form-control" name="selfRank" id="selfRank" placeholder="1">
</div>
<div class="form-group">
    <label for="relatedCourseName">关联课题</label>
    <input type="text" class="form-control" name="relatedCourseName" id="relatedCourseName" placeholder="请输入关联课题">
</div>
<!-- textarea -->
<div class="form-group">
    <label>备注</label>
    <textarea class="form-control" rows="3" name="remark" placeholder="请输入备注信息"></textarea>
</div>
