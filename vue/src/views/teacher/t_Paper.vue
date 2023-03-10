<template>
  <div style="padding: 10px">
    <div style="margin: 10px">
      <el-button @click="add">生成试卷</el-button>
    </div>

    <el-table
        :data="tableData"
        border
        stripe
        style="width: 99%;">
      <el-table-column label="试卷id" prop="id" sortable/>
      <el-table-column label="试卷名" prop="name"/>
      <el-table-column label="创建者id" prop="creator"/>
      <el-table-column label="创建时间" prop="createTime"/>
      <el-table-column width="200px" label="操作">
        <template #default="scope">
          <el-button size="small" @click="issue(scope.row)" style="margin: 0 10px">分配</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row)">
            <template #reference>
              <el-button size="small" type="danger">删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-dialog v-model="dialogTableVisible" title="分配试卷">
        <el-table :data="gridData">
          <el-table-column prop="stu_id" label="学员id" sortable/>
          <el-table-column prop="stu_name" label="姓名" />
          <el-table-column label="操作">
            <template #default="scope2">
              <el-button size="small" @click="issueTo(scope2.row,scope.row)">分配</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-dialog>
    </div>
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogFormVisible_new" title="生成试卷">
        <el-form :model="form" label-width="200px">
          <el-form-item label="试卷名" prop="need">
            <el-input v-model="form.name" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第1题" prop="need">
            <el-input v-model="form.objProblem[0]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第2题" prop="need">
            <el-input v-model="form.objProblem[1]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第3题" prop="need">
            <el-input v-model="form.objProblem[2]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第4题" prop="need">
            <el-input v-model="form.objProblem[3]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第5题" prop="need">
            <el-input v-model="form.objProblem[4]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第6题" prop="need">
            <el-input v-model="form.objProblem[5]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第7题" prop="need">
            <el-input v-model="form.objProblem[6]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第8题" prop="need">
            <el-input v-model="form.objProblem[7]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第9题" prop="need">
            <el-input v-model="form.objProblem[8]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第10题" prop="need">
            <el-input v-model="form.objProblem[9]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第11题" prop="need">
            <el-input v-model="form.objProblem[10]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第12题" prop="need">
            <el-input v-model="form.objProblem[11]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第13题" prop="need">
            <el-input v-model="form.objProblem[12]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第14题" prop="need">
            <el-input v-model="form.objProblem[13]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第15题" prop="need">
            <el-input v-model="form.objProblem[14]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第16题" prop="need">
            <el-input v-model="form.objProblem[15]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第17题" prop="need">
            <el-input v-model="form.objProblem[16]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第18题" prop="need">
            <el-input v-model="form.objProblem[17]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第19题" prop="need">
            <el-input v-model="form.objProblem[18]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第20题" prop="need">
            <el-input v-model="form.objProblem[19]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第21题" prop="need">
            <el-input v-model="form.subProblem[0]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第22题" prop="need">
            <el-input v-model="form.subProblem[1]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第23题" prop="need">
            <el-input v-model="form.subProblem[2]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第24题" prop="need">
            <el-input v-model="form.subProblem[3]" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="第25题" prop="need">
            <el-input v-model="form.subProblem[4]" style="width: 80%"/>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible_new = false">取消</el-button>
        <el-button type="primary" @click="save_new">确认</el-button>
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
  name: "t_Paper",
  data() {
    return {
      form: {
        name: "",
        creator: window.sessionStorage.getItem("id").toString(),
        objProblem: [],
        subProblem: [],
      },
      dialogTableVisible: false,
      dialogFormVisible_new: false,
      search: '',
      tableData: [],
      gridData: [],
      scope: {},
      scope2: {},
    }
  },
  created() {
    this.load()
  },
  //方法
  methods: {
    load() {
      request.get("/getPaperInfoByCreatorId",{
        params: {
          "id": window.sessionStorage.getItem("id")
        }
      }).then(res => {
        this.tableData = res.paperInfo
      })
    },
    save_new() {
      request.post("/createPaper", this.form).then(res => {
        console.log(res)
        this.load()
      })
      this.dialogFormVisible_new = false
    },
    issue(paper) {
      this.scope = paper
      this.dialogTableVisible = true
      request.get("/getAllstuByTeacherId", {
        params: {
          id: window.sessionStorage.getItem("id")
        }
      }).then(res => {
        this.gridData = res.studentInfo
      })
    },
    issueTo(stu) {
      let paper = this.scope
      request.post("/addStudentPaper", {"paperId": paper.id,"stuIds": [stu.stu_id]}).then(res => {
        console.log(res)
        if(res.code === 200) {
          ElMessage({
            type: "success",
            message: "分配成功"
          })
        }
        else {
          ElMessage({
            type: "error",
            message: "分配失败"
          })
        }
      })
    },
    add() {
      this.form = {
        name: "",
        creator: window.sessionStorage.getItem("id").toString(),
        objProblem: [],
        subProblem: [],
      }
      this.dialogFormVisible_new = true
    },
    handleDelete(row) {
      request.post("/deletePaperById", row).then(res => {
        console.log(res)
        if(res.code === 200) {
          ElMessage({
            type: "success",
            message: "删除成功"
          })
        }
        else {
          ElMessage({
            type: "error",
            message: "删除失败"
          })
        }
        this.load()
      })
    },
  }
}
</script>

<style scoped>

</style>