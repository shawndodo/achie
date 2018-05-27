<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="awardName">教学奖项名称</label>
    <input type="text"
           class="form-control"
           name="awardName"
           id="awardName"
           placeholder="请填写标题">
</div>
<div class="form-group">
    <label for="selfRank">本人排名</label>
    <input type="text"
           class="form-control"
           name="selfRank"
           id="selfRank"
           placeholder="">
</div>

<div class="form-group">
    <label>级别</label>
    <select class="form-control" name="level" id="level">
        <option value="国家级" selected="selected">国家级</option>
        <option value="省部级">省部级</option>
        <option value="其他">其他</option>
    </select>
</div>

<div class="form-group">
    <label for="awardDepartment">授予单位</label>
    <input type="text" class="form-control" name="awardDepartment" id="awardDepartment" placeholder="">
</div>

<div class="form-group">
    <label>获奖时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text"
               class="form-control pull-right"
               name="awardDate"
               id="awardDate">
    </div>
</div>

<div class="form-group">
    <label for="relatedCourseName">关联课题</label>
    <input type="text" class="form-control" name="relatedCourseName" id="relatedCourseName" placeholder="">
</div>

<div class="form-group">
    <label>备注</label>
    <textarea class="form-control" rows="3" name="remark"
              placeholder="请输入备注信息"></textarea>
</div>


