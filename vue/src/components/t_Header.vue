<template>
  <el-header style="height: 50px; line-height: 50px;width: 100%; border-bottom: 1px solid #ccc; display: flex">
    <div style="width: 200px">党的知识学习测试系统</div>
    <div style="flex: 1"></div>
    <div style="width: 150px">
      <el-dropdown>
    <span class="el-dropdown-link">
      <br>{{ name }}<el-icon class="el-icon--right"><ArrowDown /></el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item disabled>组织员</el-dropdown-item>
            <el-dropdown-item @click="$router.push('/login')">退出系统</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </el-header>
</template>

<script>

import { ArrowDown } from '@element-plus/icons-vue'

export default {
  name: "t_Header",
  data() {
    return {
      name: window.sessionStorage.getItem("name")
    }
  },
  components: {
    ArrowDown,
  }
}
</script>

<style scoped>

</style>