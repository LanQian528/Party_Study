<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="1"
        router
        class="el-menu-vertical-demo">
      <el-menu-item index="/s_zice">
        <el-icon><document /></el-icon>
        自我检测
      </el-menu-item>
      <el-menu-item index="/s_kaohe">
        <el-icon><document /></el-icon>
        正式考核
      </el-menu-item>
      <el-menu-item index="/s_grade">
        <el-icon><IconMenu /></el-icon>
        考核情况
      </el-menu-item>
      <el-menu-item index="/s_info">
        <el-icon><Setting /></el-icon>
        个人信息
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
  name: "s_Aside",
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