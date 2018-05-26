<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="paperName">论文名称</label>
    <input type="text" class="form-control" name="paperName" id="paperName" placeholder="请填写标题">
</div>
<div class="form-group">
    <label>论文类型</label>
    <select class="form-control" name="paperType">
        <option value="期刊论文" selected="selected">期刊论文</option>
        <option value="会议论文集">会议论文集</option>
        <option value="报纸">报纸</option>
        <option value="学位论文">学位论文</option>
    </select>
</div>
<div class="form-group">
    <label for="selfRank">本人排名</label>
    <input type="text" class="form-control" name="selfRank" id="selfRank" placeholder="1">
</div>
<div class="form-group">
    <label>是否独著</label>
    <select class="form-control" name="isAlone">
        <option value="是" selected="selected">是</option>
        <option value="否">否</option>
    </select>
</div>
<div class="form-group">
    <label>通讯作者</label>
    <select class="form-control" name="messageAuthor">
        <option value="是" selected="selected">是</option>
        <option value="否">否</option>
    </select>
</div>
<div class="form-group">
    <label for="periodicalName">刊物名称</label>
    <input type="text" class="form-control" name="periodicalName" id="periodicalName" placeholder="如：装饰">
</div>
<div class="form-group">
    <label for="inclusionSearch">收录检索(刊物级别)</label>
    <input type="text" class="form-control" name="inclusionSearch" id="inclusionSearch" placeholder="请输入刊物级别">
</div>
<div class="form-group">
    <label>发表时间</label>

    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text" class="form-control pull-right" name="publishTime" id="publishTime">
    </div>
</div>
<div class="form-group">
    <label for="keyWord">关键词</label>
    <input type="text" class="form-control" name="keyWord" id="keyWord" placeholder="如：机器学习，生物化学">
</div>
<div class="form-group">
    <label for="edition">卷(期、版次)</label>
    <input type="text" class="form-control" name="edition" id="edition" placeholder="格式为：卷(期)，如12(04)">
</div>
<div class="form-group">
    <label for="edition">起止页码</label>
    <input type="text" class="form-control" name="startEndPageNum" id="startEndPageNum" placeholder="如：21~24">
</div>

<div class="form-group">
    <label for="doiNum">DOI号</label>
    <input type="text" class="form-control" name="doiNum" id="doiNum" placeholder="请输入DOI号">
</div>

<div class="form-group">
    <label for="issnNum">ISSN号</label>
    <input type="text" class="form-control" name="issnNum" id="issnNum" placeholder="请输入ISSN号">
</div>

<div class="form-group">
    <label for="cnNum">CN号</label>
    <input type="text" class="form-control" name="cnNum" id="cnNum" placeholder="请输入CN号">
</div>

<div class="form-group">
    <label for="impactFactor">影响因子</label>
    <input type="text" class="form-control" name="impactFactor" id="impactFactor" placeholder="如：3.102">
</div>

<div class="form-group">
    <label for="quotesNum">引用次数</label>
    <input type="text" class="form-control" name="quotesNum" id="quotesNum" placeholder="请输入论文引用次数">
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
