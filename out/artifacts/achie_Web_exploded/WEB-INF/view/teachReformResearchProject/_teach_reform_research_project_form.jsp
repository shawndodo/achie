<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="code">项目编号</label>
    <input type="text"
           class="form-control"
           name="code"
           id="code"
           placeholder="">
</div>
<div class="form-group">
    <label for="name">项目名称</label>
    <input type="text"
           class="form-control"
           name="name"
           id="name"
           placeholder="">
</div>

<div class="form-group">
    <label>级别</label>
    <select class="form-control" name="level" id="level">
        <option value="国家级" selected="selected">国家级</option>
        <option value="省部级">省部级</option>
        <option value="校级">校级</option>
        <option value="其他">其他</option>
    </select>
</div>

<div class="form-group">
    <label for="leader">主持人</label>
    <input type="text"
           class="form-control"
           name="leader"
           id="leader"
           placeholder="">
</div>

<div class="form-group">
    <label for="year">年度</label>
    <input type="text"
           class="form-control"
           name="year"
           id="year"
           placeholder="">
</div>

<div class="form-group">
    <label>备注</label>
    <textarea class="form-control"
              rows="3"
              name="remark"
              placeholder="请输入备注信息"></textarea>
</div>


