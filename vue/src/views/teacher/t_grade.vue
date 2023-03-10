<template>
  <div style="padding: 20px">

    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%;">
      <el-table-column label="考核id" prop="id" sortable width="100px"/>
      <el-table-column label="学员" prop="stu_name"/>
      <el-table-column label="试卷" prop="paper_name"/>
      <el-table-column label="客观题成绩" prop="objGrade"/>
      <el-table-column label="第一题" prop="eryi"/>
      <el-table-column label="第二题" prop="erer"/>
      <el-table-column label="第三题" prop="ersan"/>
      <el-table-column label="第四题" prop="ersi"/>
      <el-table-column label="第五题" prop="erwu"/>
      <el-table-column label="操作" min-width="75px">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">录入成绩</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogFormVisible" title="录入成绩" width="20%">
        <el-form :model="form" :rules="rules" :show-message=true>
          <el-form-item label="正确主观题数目" prop="need">
            <el-input v-model="form.subGrade"/>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确认</el-button>
      </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import request from "@/utils/requests";
import {ElMessage} from "element-plus";

export default {
  name: "t_grade",
components: {},
//变量
data() {
  return {
    form: {},
    dialogFormVisible: false,
    tableData: [],
    scope: {},
  }
},
created() {
  this.load()
},
//方法
methods: {
  load() {
    request.get("/getAllAnswer").then(res => {
      this.tableData = res.info
    })
  },
  save() {
    this.form.subGrade = this.form.subGrade * 4
    request.post("/insertSubGrade", this.form).then(res => {
      console.log(res)
      if(res.code === 200) {
        ElMessage({
          type: "success",
          message: "录入成功"
        })
      }
      else {
        ElMessage({
          type: "error",
          message: "录入失败"
        })
      }
      this.load()
    })
    this.dialogFormVisible = false
  },
  handleEdit(row) {
    this.form = row
    this.dialogFormVisible = true
  },
}
}
</script>

<style scoped>

</style>