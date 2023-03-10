<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="1"
        router
        class="el-menu-vertical-demo">
      <el-menu-item index="/t_stu_ctrl">
        <el-icon><IconMenu /></el-icon>
        学员管理
      </el-menu-item>
      <el-menu-item index="/t_paper">
        <el-icon><Setting /></el-icon>
        试卷管理
      </el-menu-item>
      <el-menu-item index="/t_grade">
        <el-icon><document /></el-icon>
        录入学员成绩
      </el-menu-item>
      <el-menu-item index="/t_obj_ctrl">
        <el-icon><document /></el-icon>
        客观题库
      </el-menu-item>
      <el-menu-item index="/t_sub_ctrl">
        <el-icon><document /></el-icon>
        主观题库
      </el-menu-item>
      <el-menu-item index="/t_data_show">
        <el-icon><Location /></el-icon>
        数据统计
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
import {
  Document,
  Menu as IconMenu,
  Location,
  Setting,
} from '@element-plus/icons-vue'
export default {
  name: "t_Aside",
  components: {
    Document,
    IconMenu,
    Location,
    Setting,
  }
}
</script>

<style scoped>

</style>