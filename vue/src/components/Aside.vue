<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="1"
        router
        class="el-menu-vertical-demo">
      <el-menu-item index="/stu_ctrl">
        <el-icon><icon-menu /></el-icon>
        学员管理
      </el-menu-item>
      <el-menu-item index="/org_ctrl">
        <el-icon><setting /></el-icon>
        组织部管理
      </el-menu-item>
      <el-menu-item index="/obj_ctrl">
        <el-icon><document /></el-icon>
        客观题库
      </el-menu-item>
      <el-menu-item index="/sub_ctrl">
        <el-icon><document /></el-icon>
        主观题库
      </el-menu-item>
      <el-menu-item index="/data_show">
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
  name: "Aside",
  data() {
    return {}
  },
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