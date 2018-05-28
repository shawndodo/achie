<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="name">学术会议名称</label>
    <input type="text"
           class="form-control"
           name="name"
           id="name"
           placeholder="">
</div>
<div class="form-group">
    <label for="location">会议地点</label>
    <input type="text"
           class="form-control"
           name="location"
           id="location"
           placeholder="">
</div>

<div class="form-group">
    <label>会议等级</label>
    <select class="form-control select2" style="width: 100%;" id="level" name="level">
        <option value="国际" selected="selected">国际</option>
        <option value="国家">国家</option>
        <option value="省市">省市</option>
    </select>
</div>

<div class="form-group">
    <label for="participant">参加人</label>
    <input type="text"
           class="form-control"
           name="participant"
           id="participant"
           placeholder="">
</div>

<div class="form-group">
    <label for="title">职称</label>
    <input type="text"
           class="form-control"
           name="title"
           id="title"
           placeholder="">
</div>

<div class="form-group">
    <label for="paperName">提交论文</label>
    <input type="text"
           class="form-control"
           name="paperName"
           id="paperName"
           placeholder="">
</div>

<div class="form-group">
    <label>是否独著</label>
    <select class="form-control select2" style="width: 100%;" id="isInviteReport" name="isInviteReport">
        <option value="是" selected="selected">是</option>
        <option value="否">否</option>
    </select>
</div>

<div class="form-group">
    <label for="subjectCategory">所属学科</label>
    <input type="text"
           class="form-control"
           name="subjectCategory"
           id="subjectCategory"
           placeholder="">
</div>

<div class="form-group">
    <label>提交时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text"
               class="form-control pull-right"
               name="submitDate"
               id="submitDate">
    </div>
</div>



<div class="form-group">
    <label>备注</label>
    <textarea class="form-control"
              rows="3"
              name="remark"
              placeholder="请输入备注信息"></textarea>
</div>


