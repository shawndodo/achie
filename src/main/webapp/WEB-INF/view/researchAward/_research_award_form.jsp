<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="awardName">成果名称</label>
    <input type="text" class="form-control" name="awardName" id="awardName" placeholder="请填写成果名">
</div>
<div class="form-group">
    <label for="publishJournal">发表刊物</label>
    <input type="text" class="form-control" name="publishJournal" id="publishJournal" placeholder="">
</div>
<div class="form-group">
    <label for="publisher">出版单位</label>
    <input type="text" class="form-control" name="publisher" id="publisher" placeholder="">
</div>
<div class="form-group">
    <label>出版时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="publishDate" id="publishDate">
    </div>
</div>

<div class="form-group">
    <label for="awardWinningName">获奖名称</label>
    <input type="text" class="form-control" name="awardWinningName" id="awardWinningName" placeholder="">
</div>

<div class="form-group">
    <label>获奖类别</label>
    <select class="form-control" name="awardType" id="awardType">
        <option value="国家级" selected="selected">国家级</option>
        <option value="省部级">省部级</option>
        <option value="其他">其他</option>
    </select>
</div>

<div class="form-group">
    <label for="awardDepartment">颁奖主管部门</label>
    <input type="text" class="form-control" name="awardDepartment" id="awardDepartment" placeholder="">
</div>

<div class="form-group">
    <label>奖励日期(证书日期)</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="awardDate" id="awardDate">
    </div>
</div>

<div class="form-group">
    <label for="awardNumber">证书号</label>
    <input type="text" class="form-control" name="awardNumber" id="awardNumber" placeholder="">
</div>

<div class="form-group">
    <label for="unitRank">单位排名</label>
    <input type="text" class="form-control" name="unitRank" id="unitRank" placeholder="">
</div>

<div class="form-group">
    <label for="selfRank">个人排名</label>
    <input type="text" class="form-control" name="selfRank" id="selfRank" placeholder="">
</div>

<div class="form-group">
    <label for="subjectCategory">学科门类(按一级学科目录填写)</label>
    <input type="text" class="form-control" name="subjectCategory" id="subjectCategory" placeholder="">
</div>

<div class="form-group">
    <label>备注</label>
    <textarea class="form-control" rows="3" name="remark"
              placeholder="请输入备注信息"></textarea>
</div>