<template>
  <div style="padding: 10px">
    <div style="margin: 10px">
      <el-button @click="add">新增</el-button>
      <el-button style="margin:0 5px;float: right" type="primary" @click="load_search">查询</el-button>
      <el-input v-model="search" placeholder="请输入id" size="big" style="margin:0 5px;width: 20%;float: right"/>
    </div>

    <el-table
        :data="tableData"
        border
        stripe
        style="width: 100%;">
      <el-table-column label="id" prop="stu_id" sortable width="80px"/>
      <el-table-column label="密码" prop="stu_pass" width="120">******</el-table-column>
      <el-table-column label="姓名" prop="stu_name" width="120"/>
      <el-table-column label="年级" prop="stu_grade" width="120"/>
      <el-table-column label="学院" prop="stu_school" width="180"/>
      <el-table-column label="组织部" prop="stu_orgamem" width="180"/>
      <el-table-column label="专业" prop="major" width="180"/>
      <el-table-column label="学习情况" prop="grades" width="200">
        <template #default="scope2">
        <el-button style="margin-right: 16px" @click="kaohe(scope2.row)">查看考核情况</el-button>
        </template>
      </el-table-column>
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
    <div>
        <el-dialog placement="left" v-model="pop" width="50%">
          <el-table :data="gridData">
            <el-table-column label="正确题目数量" prop="correctedNum"/>
            <el-table-column label="错误题目数量" prop="disCorrectedNum"/>
            <el-table-column label="考核党支部" prop="questionMaster"/>
            <el-table-column label="志愿书编号" prop="id"/>
            <el-table-column label="成绩创建时间" prop="createTime" min-width="120px"/>
          </el-table>
        </el-dialog>
    </div>
    <div style="margin: 10px 0">
      <el-dialog v-model="dialogFormVisible_new" title="新增学员" width="25%">
        <el-form :model="form" :rules="rules" label-width="100px">
          <el-form-item label="学员id" prop="need">
            <el-input v-model="form.id" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="密码" prop="need">
            <el-input v-model="form.pass" style="width: 80%" type="password"/>
          </el-form-item>
          <el-form-item label="姓名" prop="need">
            <el-input v-model="form.name" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="年级" prop="need">
            <el-input v-model="form.grade" style="width: 80%"/>
          </el-form-item>
          <div style="width: 80%; margin-left: 50px;margin-bottom: 20px">
            <span style="margin: 10px;width: 100px">学院</span>
            <el-select style="width: calc(80% - 23px)" v-model="form.school" placeholder="选择学院">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
          </div>
          <el-form-item label="组织员id" prop="need">
            <el-input v-model="form.orgamem" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="专业" prop="need">
            <el-input v-model="form.major" style="width: 80%"/>
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
      <el-dialog v-model="dialogFormVisible" title="编辑学员" width="25%">
        <el-form :model="form" :rules="rules" :show-message=true label-width="100px">
          <el-form-item label="密码" prop="need">
            <el-input v-model="form.stu_pass" style="width: 80%" type="password"/>
          </el-form-item>
          <el-form-item label="姓名" prop="need">
            <el-input v-model="form.stu_name" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="年级" prop="need">
            <el-input v-model="form.stu_grade" style="width: 80%"/>
          </el-form-item>
          <div style="width: 80%; margin-left: 50px;margin-bottom: 20px">
            <span style="margin: 10px;width: 100px">学院</span>
            <el-select style="width: calc(80% - 23px)" v-model="form.stu_school" placeholder="选择学院">
              <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
              />
            </el-select>
          </div>
          <el-form-item label="组织员id" prop="need">
            <el-input v-model="form.stu_orgamem" style="width: 80%"/>
          </el-form-item>
          <el-form-item label="专业" prop="need">
            <el-input v-model="form.major" style="width: 80%"/>
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
  name: 'Stu_ctrl',
  components: {},
  //变量
  data() {
    return {
      form: {},
      pop: false,
      dialogFormVisible: false,
      dialogFormVisible_new: false,
      search: '',
      tableData: [],
      gridData: [],
      scope: {},
      scope2: {},
      rules:{
        need: [
          { required: false,
            message: '这一项是必须输入的！',}
        ],},
      options : [
        {
          value: '1',
          label: '地球科学与技术学院',
        },
        {
          value: '2',
          label: '石油工程学院',
        },
        {
          value: '3',
          label: '化学工程学院',
        },
        {
          value: '4',
          label: '机电工程学院',
        },
        {
          value: '5',
          label: '储运与建筑工程学院',
        },
        {
          value: '6',
          label: '材料科学与工程学院',
        },
        {
          value: '7',
          label: '新能源学院',
        },
        {
          value: '8',
          label: '海洋与空间信息学院',
        },
        {
          value: '9',
          label: '控制科学与工程学院',
        },
        {
          value: '10',
          label: '计算机科学与技术学院',
        },
        {
          value: '11',
          label: '海洋与空间信息学院',
        },
        {
          value: '12',
          label: '经济管理学院',
        },
        {
          value: '13',
          label: '储运与建理学院筑工程学院',
        },
        {
          value: '14',
          label: '外国语学院',
        },
        {
          value: '15',
          label: '文法学院',
        },
        {
          value: '16',
          label: '马克思主义学院',
        },
        {
          value: '17',
          label: '体育教学部',
        },
      ]
    }
  },
  created() {
    this.load()
  },
  //方法
  methods: {
    kaohe(row) {
      this.gridData = row.grades
      console.log(this.gridData)
      this.pop = true
    },
    load_search() {
      request.get("/getStuInfo", {
        params: {
          'id' : this.search
        }
      }).then(res => {
        this.tableData = [res]
      })
      if(!this.search){
        this.load()
      }
    },
    load() {
      request.get("/getAllStuInfo").then(res => {
        this.tableData = res.students
    })
    },
    save_new() {
      request.post("/insertStudent", this.form).then(res => {
        console.log(res)
        this.load()
      })
      this.dialogFormVisible_new = false
    },
    save() {
      request.post("/updateStudent", this.form).then(res => {
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
      this.form.stu_school = ""
      this.form.stu_orgamem = ""
      this.dialogFormVisible = true
    },
    handleDelete(row) {
        request.post("/deleteStudent", row).then(res => {
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
