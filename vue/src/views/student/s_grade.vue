<template>
<div style="margin: 10px">
  <el-table
      :data="tableData"
      border
      stripe
      style="width: 100%;">
    <el-table-column label="学员姓名" prop="name"/>
    <el-table-column label="最终成绩" prop="grade"/>
    <el-table-column label="正确题目数量" prop="correctedNum"/>
    <el-table-column label="错误题目数量" prop="disCorrectedNum"/>
    <el-table-column label="考核党支部" prop="questionMaster"/>
    <el-table-column label="志愿书编号" prop="id"/>
    <el-table-column label="成绩创建时间" prop="createTime" min-width="120px"/>
  </el-table>
</div>
</template>

<script>
import request from "@/utils/requests";

export default {
  name: "s_grade",
  data() {
    return {
      form: {},
      tableData: [],
      scope: {},
      id: window.sessionStorage.getItem("id"),
    }
  },
  created() {
    this.load()
  },
  //方法
  methods: {
    load() {
      request.get("/getHistory",{
        params: {
          "id": this.id
        }
      }).then(res => {
        this.tableData = res.history
      })
    },
  }
}
</script>

<style scoped>

</style>