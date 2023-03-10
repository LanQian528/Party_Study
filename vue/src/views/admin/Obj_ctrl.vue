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
      <el-table-column label="id" prop="objectpro_id" sortable width="80px"/>
      <el-table-column label="题干" prop="objectpro_com" width="400px"/>
      <el-table-column label="A选项" prop="objectpro_A"/>
      <el-table-column label="B选项" prop="objectpro_B"/>
      <el-table-column label="C选项" prop="objectpro_C"/>
      <el-table-column label="D选项" prop="objectpro_D"/>
      <el-table-column label="答案" prop="objectpro_ans"/>
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
      <el-dialog v-model="dialogFormVisible_new" title="新增客观题">
        <el-form :model="form" :rules="rules" label-width="200px">
          <el-form-item label="题干" prop="need">
            <el-input v-model="form.com" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="A选项" prop="need">
            <el-input v-model="form.a" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="B选项" prop="need">
            <el-input v-model="form.b" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="C选项" prop="need">
            <el-input v-model="form.c" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="D选项" prop="need">
            <el-input v-model="form.d" style="width: 80%" type="textarea"/>
          </el-form-item>
          <div style="width: 80%; margin-left: 200px;margin-bottom: 20px">
            <span style="margin: 10px;width: 100px">正确答案</span>
            <el-select style="width:20%" v-model="form.ans" placeholder="选择选项">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.value"
                  :value="item.value"
              />
            </el-select>
          </div>
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
      <el-dialog v-model="dialogFormVisible" title="编辑客观题">
        <el-form :model="form" :rules="rules" label-width="200px">
          <el-form-item label="题干" prop="need">
            <el-input v-model="form.objectpro_com" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="A选项" prop="need">
            <el-input v-model="form.objectpro_A" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="B选项" prop="need">
            <el-input v-model="form.objectpro_B" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="C选项" prop="need">
            <el-input v-model="form.objectpro_C" style="width: 80%" type="textarea"/>
          </el-form-item>
          <el-form-item label="D选项" prop="need">
            <el-input v-model="form.objectpro_D" style="width: 80%" type="textarea"/>
          </el-form-item>
          <div style="width: 80%; margin-left: 200px;margin-bottom: 20px">
            <span style="margin: 10px;width: 100px">正确答案</span>
            <el-select style="width:20%" v-model="form.objectpro_ans" placeholder="选择选项">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.value"
                  :value="item.value"
              />
            </el-select>
          </div>
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
  name: 'Obj_ctrl',
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
      request.get("/getAllObjPro").then(res => {
        this.tableData = res.objectproblems
      })
    },
    save_new() {
      request.post("/insertProblem", this.form).then(res => {
        console.log(res)
        this.load()
      })
      this.dialogFormVisible_new = false
    },
    save() {
      request.post("/updateObjProblem", this.form).then(res => {
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
      request.post("/deleteProblem", row).then(res => {
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