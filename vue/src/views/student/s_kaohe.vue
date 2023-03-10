<template>
  <div style="margin: 10px">
    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%;">
      <el-table-column label="试卷id" prop="id" sortable/>
      <el-table-column label="试卷名" prop="name"/>
      <el-table-column label="创建者id" prop="creator"/>
      <el-table-column label="创建时间" prop="createTime"/>
      <el-table-column width="150px" label="操作">
        <template #default="scope">
          <el-button size="small" @click="ceshi(scope.row)" style="margin: 0 10px">测试</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/requests";

export default {
  name: "s_kaohe",
  data() {
    return {
      form: {},
      tableData: [],
      scope: {},
      id: window.sessionStorage.getItem("id"),
      stuinfo: {},
    }
  },
  created() {
    this.load()
  },
  //方法
  methods: {
    load() {
        request.get("/getMypaper",{
          params: {
            "id": this.id
          }
        }).then(res => {
          this.tableData = res.paperInfo
        })
    },
    ceshi(row) {
      window.sessionStorage.setItem("paper", row.id)
      window.sessionStorage.setItem("type", 1)
      this.$router.push("/s_exam")
    },
  }
}
</script>

<style scoped>

</style>