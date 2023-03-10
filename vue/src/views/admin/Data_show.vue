<template>
  <div style="padding: 10px">
    <br>
    <h3 style="text-align: center;color: cadetblue">
      各学院积极分子人数统计
    </h3>
    <br>
    <el-table
        :data="tableData"
        border
        stripe
        style="width: 99%;">
      <el-table-column label="学院" prop="name" sortable/>
      <el-table-column label="积极分子人数" prop="value" sortable/>
    </el-table>
    <br>
    <h3 style="text-align: center;color: cadetblue">
      各学院积极分子已完成考核人数统计
    </h3>
    <br>
    <el-table
        :data="tableData2"
        border
        stripe
        style="width: 99%;">
      <el-table-column label="学院" prop="name" sortable/>
      <el-table-column label="积极分子人数" prop="value" sortable/>
    </el-table>
  </div>
</template>

<script>
import request from "@/utils/requests";

export default {
  name: "Data_show",
  data() {
    return {
      tableData: [],
      tableData2: [],
    }
  },
  created() {
    this.load()
  },
  methods:{
    load() {
      request.get("/getMeigeSchoolRenshu").then(res => {
        this.tableData = res.data
      })
      request.get("/getKaoheRenshu").then(res => {
        this.tableData2 = res.data
      })
    },
  }
}
</script>
<style scoped>

</style>