<%--
  Created by IntelliJ IDEA.
  User: dodo
  Date: 2018/4/18
  Time: 上午1:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="<%=request.getContextPath()%>/statics/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <%--在类似局部视图的文件里不需要再声明--%>
                <%--<%--%>
                    <%--String userName = (String) session.getAttribute("loginName");--%>
                <%--%>--%>
                <p><%=realName%></p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="搜索">
                <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">菜单</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><a href="#"><i class="fa fa-user"></i> <span>个人中心</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa fa-bookmark-o"></i> <span>教学成果</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/achie/writing/index"><i class="fa fa-circle-o text-aqua"></i>著作管理</a></li>
                    <li><a href="/achie/teachAward/index"><i class="fa fa-circle-o text-aqua"></i>教学奖项管理</a></li>
                    <li><a href="/achie/studentProject/index"><i class="fa fa-circle-o text-aqua"></i>指导学生项目管理</a></li>
                    <li><a href="/achie/teachPaper/index"><i class="fa fa-circle-o text-aqua"></i>教学论文管理</a></li>
                    <li><a href="/achie/teachReformResearchProject/index"><i class="fa fa-circle-o text-aqua"></i>主持教学改革研究项目管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#"><i class="fa fa-balance-scale"></i> <span>科研成果</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/achie/patent/index"><i class="fa fa-circle-o text-aqua"></i>专利管理</a></li>
                    <li><a href="/achie/softwareCopyright/index"><i class="fa fa-circle-o text-aqua"></i>软件著作权管理</a></li>
                    <li><a href="/achie/paper/index"><i class="fa fa-circle-o text-aqua"></i>论文管理</a></li>
                    <li><a href="/achie/paper/index"><i class="fa fa-circle-o text-aqua"></i>参与学术会议管理</a></li>
                    <li><a href="/achie/researchAward/index"><i class="fa fa-circle-o text-aqua"></i>获奖成果管理</a></li>
                    <li><a href="/achie/researchProject/index"><i class="fa fa-circle-o text-aqua"></i>科研项目管理</a></li>
                </ul>
            </li>
            <li><a href="#"><i class="fa fa-bar-chart"></i> <span>成果统计</span></a></li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
