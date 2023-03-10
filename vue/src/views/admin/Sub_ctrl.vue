<template>
  <div style="padding: 10px">
    <div style="margin: 10px">
      <el-button @click="add">新增</el-button>
    </div>

    <el-table
        :data="tableData"
        border
        stripe
        style="width: 99%;">
      <el-table-column label="id" prop="subpro_id" sortable width="80px"/>
      <el-table-column label="题干" prop="subpro_com" width="400px"/>
      <el-table-column label="参考答案" prop="subpro_ans"/>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row)">
            <template #reference>
              <el-button size="small" type="danger">
                删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogFormVisible_new" title="新增主观题">
        <el-form :model="form" :rules="rules" label-width="200px">
          <el-form-item label="题干" prop="need">
            <el-input v-model="form.subpro_com" style="width: 80%" autosize type="textarea"/>
          </el-form-item>
          <el-form-item label="答案" prop="need">
            <el-input v-model="form.subpro_ans" style="width: 80%" autosize type="textarea"/>
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
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogFormVisible" title="编辑主观题">
        <el-form :model="form" :rules="rules" label-width="200px">
          <el-form-item label="题干" prop="need">
            <el-input v-model="form.subpro_com" style="width: 80%" autosize type="textarea"/>
          </el-form-item>
          <el-form-item label="答案" prop="need">
            <el-input v-model="form.subpro_ans" style="width: 80%" autosize type="textarea"/>
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
  name: "Sub_ctrl",
  components: {},
  //变量
  data() {
    return {
      form: {},
      dialogFormVisible: false,
      dialogFormVisible_new: false,
      search: '',
      tableData: [],
      scope: {},
      rules:{
        need: [
          { required: false,
            message: '这一项是必须输入的！',}
        ],},
      options : [
        {
          value: 'A',
        },
        {
          value: 'B',
        },
        {
          value: 'C',
        },
        {
          value: 'D',
        },
      ]
    }
  },
  created() {
    this.load()
  },
  //方法
  methods: {
    load() {
      request.get("/getAllSubProblem").then(res => {
        this.tableData = res.allsubProblem
      })
    },
    save_new() {
      request.post("/insertSubProblem", this.form).then(res => {
        console.log(res)
        this.load()
      })
      this.dialogFormVisible_new = false
    },
    save() {
      request.post("/updateSubjProblem", this.form).then(res => {
        console.log(res)
        if(res.code === 200) {
          ElMessage({
            type: "success",
            message: "编辑成功"
          })
        }
        else {
          ElMessage({
            type: "error",
            message: "编辑失败"
          })
        }
        this.load()
      })
      this.dialogFormVisible = false
    },
    add() {
      this.form = {}
      this.dialogFormVisible_new = true
    },
    handleEdit(row) {
      this.form = row
      this.dialogFormVisible = true
    },
    handleDelete(row) {
      request.post("/deleteSubProblem", row).then(res => {
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