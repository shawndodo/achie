<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="writingName">著作名称</label>
    <input type="text" class="form-control" name="writingName" id="writingName" placeholder="请填写标题">
</div>
<div class="form-group">
    <label for="publicationNumber">出版号</label>
    <input type="text" class="form-control" name="publicationNumber" id="publicationNumber" placeholder="如ISBN 123-1-123-12345-1">
</div>

<div class="form-group">
    <label>身份</label>
    <select class="form-control" name="selfPosition">
        <option value="著作" selected="selected">著作</option>
        <option value="总主编">总主编</option>
        <option value="副主编">副主编</option>
        <option value="主编">主编</option>
        <option value="参编">参编</option>
        <option value="主审">主审</option>
        <option value="其他">其他</option>
    </select>
</div>

<div class="form-group">
    <label for="selfRank">本人排名</label>
    <input type="text" class="form-control" name="selfRank" id="selfRank" placeholder="1">
</div>

<div class="form-group">
    <label for="press">出版社</label>
    <input type="text" class="form-control" name="press" id="press" placeholder="例: 北京邮电出版社">
</div>

<div class="form-group">
    <label>著作类型</label>
    <select class="form-control" name="writingType">
        <option value="非教材" selected="selected">非教材</option>
        <option value="普通教材">普通教材</option>
        <option value="省级规划教材">省级规划教材</option>
        <option value="国家级规划教材">国家级规划教材</option>
    </select>
</div>

<div class="form-group">
    <label>出版时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="publishTime" id="publishTime">
    </div>
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
