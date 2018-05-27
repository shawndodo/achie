<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 下午4:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-group">
    <label for="copyrightName">著作权名称</label>
    <input type="text"
           class="form-control"
           name="copyrightName"
           id="copyrightName"
           placeholder="请填写标题">
</div>
<div class="form-group">
    <label for="certificateNum">证书号</label>
    <input type="text"
           class="form-control"
           name="certificateNum"
           id="certificateNum"
           placeholder="请填写证书右上角的[软著登字xxx]">
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
    <label>开发完成时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text"
               class="form-control pull-right"
               name="developFinishDate"
               id="developFinishDate">
    </div>
</div>

<div class="form-group">
    <label>获得时间</label>
    <div class="input-group date">
        <div class="input-group-addon">
            <i class="fa fa-calendar"></i>
        </div>
        <input type="text"
               class="form-control pull-right"
               name="getDate"
               id="getDate">
    </div>
</div>

<div class="form-group">
    <label>著作权类型</label>
    <select class="form-control" name="copyrightType" id="copyrightType">
        <option value="软件制品" selected="selected">软件制品</option>
        <option value="音像制品">音像制品</option>
    </select>
</div>

<div class="form-group">
    <label for="copyrightPerson">著作权人</label>
    <input type="text"
           class="form-control"
           name="copyrightPerson"
           id="copyrightPerson"
           placeholder="">
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