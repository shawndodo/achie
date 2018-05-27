<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="leader">负责人</label>
    <input type="text"
           class="form-control"
           name="leader"
           id="leader"
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
    <label>项目来源</label>
    <select class="form-control" name="projectType" id="projectType">
        <option value="国家社科" selected="selected">国家社科</option>
        <option value="国家自然科学基金">国家自然科学基金</option>
        <option value="教育部人文社科">教育部人文社科</option>
        <option value="省科技项目">省科技项目</option>
        <option value="省市社科基金">省市社科基金</option>
        <option value="省教育厅社科项目">省教育厅社科项目</option>
        <option value="省教育厅自然科学项目">省教育厅自然科学项目</option>
        <option value="地市厅局等政府部门项目">地市厅局等政府部门项目</option>
        <option value="企事业单位委托项目">企事业单位委托项目</option>
        <option value="学校基金项目项目">学校基金项目项目</option>
        <option value="其他研究项目">其他研究项目</option>
        <option value="无依托项目研究成果">无依托项目研究成果</option>
    </select>
</div>

<div class="form-group">
    <label for="approvalNumber">批准号</label>
    <input type="text"
           class="form-control"
           name="approvalNumber"
           id="approvalNumber"
           placeholder="">
</div>

<div class="form-group">
    <label>研究类别</label>
    <select class="form-control" name="researchCategory" id="researchCategory">
        <option value="(社科类)基础研究" selected="selected">(社科类)基础研究</option>
        <option value="应用研究">应用研究</option>
        <option value="(自然科学类)基础研究">(自然科学类)基础研究</option>
        <option value="应用研究">应用研究</option>
        <option value="试验发展">试验发展</option>
        <option value="研究与发展成果应用">研究与发展成果应用</option>
        <option value="其他科技服务">其他科技服务</option>
    </select>
</div>

<div class="form-group">
    <label for="approvalFund">批准经费(单位万元)</label>
    <input type="text"
           class="form-control"
           name="approvalFund"
           id="approvalFund"
           placeholder="">
</div>

<div class="form-group">
    <label for="currentYearInMoney">本年度到账经费(单位万元)</label>
    <input type="text"
           class="form-control"
           name="currentYearInMoney"
           id="currentYearInMoney"
           placeholder="">
</div>

<div class="form-group">
    <label for="currentYearOutMoney">本年度支出(单位万元)精确到千元</label>
    <input type="text"
           class="form-control"
           name="currentYearOutMoney"
           id="currentYearOutMoney"
           placeholder="">
</div>

<div class="form-group">
    <label for="subjectCategory">学科门类(按一级学科目录填写)</label>
    <input type="text"
           class="form-control"
           name="subjectCategory"
           id="subjectCategory"
           placeholder="">
</div>

<div class="form-group">
    <label for="organizationForm">组织形式(牵头单位/合作单位)</label>
    <input type="text"
           class="form-control"
           name="organizationForm"
           id="organizationForm"
           placeholder="">
</div>

<div class="form-group">
    <label for="serveNationalEconomyIndustry">服务的国名经济行业</label>
    <input type="text"
           class="form-control"
           name="serveNationalEconomyIndustry"
           id="serveNationalEconomyIndustry"
           placeholder="">
</div>

<div class="form-group">
    <label for="projectGoal">项目的社会经济目标</label>
    <input type="text"
           class="form-control"
           name="projectGoal"
           id="projectGoal"
           placeholder="">
</div>

<div class="form-group">
    <label>项目状态</label>
    <select class="form-control" name="projectStatus" id="projectStatus">
        <option value="在研" selected="selected">在研</option>
        <option value="结题">结题</option>
    </select>
</div>

<div class="form-group">
    <label>备注</label>
    <textarea class="form-control"
              rows="3"
              name="remark"
              placeholder="请输入备注信息"></textarea>
</div>


