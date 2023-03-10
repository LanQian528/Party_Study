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
        style="width: 99%;">
      <el-table-column label="组织员id" prop="ormem_id" sortable width="120"/>
      <el-table-column label="组织员账号" prop="ormem_acc"/>
      <el-table-column label="组织员密码" prop="ormem_pass">******</el-table-column>
      <el-table-column label="党支部名称" prop="ormem_name"/>
      <el-table-column label="归属学院" prop="school"/>
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
      <el-dialog v-model="dialogFormVisible_new" title="新增组织员" width="25%">
        <el-form :model="form" :rules="rules" label-width="100px">
          <el-form-item label="组织员账号" prop="need">
            <el-input v-model="form.acc" style="width: 80%" />
          </el-form-item>
          <el-form-item label="组织员密码" prop="need">
            <el-input v-model="form.pass" style="width: 80%" type="password"/>
          </el-form-item>
          <el-form-item label="党支部名称" prop="need">
            <el-input v-model="form.name" style="width: 80%"/>
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
      <el-dialog v-model="dialogFormVisible" title="编辑组织员" width="25%">
        <el-form :model="form" :rules="rules" :show-message=true label-width="100px">
          <el-form-item label="组织员密码" prop="need">
            <el-input v-model="form.ormem_pass" style="width: 80%" type="password"/>
          </el-form-item>
          <el-form-item label="党支部名称" prop="need">
            <el-input v-model="form.ormem_name" style="width: 80%"/>
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
  name: 'Org_ctrl',
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
    load_search() {
      request.get("/getTeacherInfo", {
        params: {
          'id' : this.search
        }
      }).then(res => {
        this.tableData = [res.info]
      })
      if(!this.search){
        this.load()
      }
    },
    load() {
      request.get("/getAllTeacherInfo").then(res => {
        this.tableData = res.teacherInfo
      })
    },
    save_new() {
      request.post("/insertTeacher", this.form).then(res => {
        console.log(res)
        this.load()
      })
      this.dialogFormVisible_new = false
    },
    save() {
      request.post("/updateTeacherInfo", this.form).then(res => {
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
      this.form.school = ""
      this.dialogFormVisible = true
    },
    handleDelete(row) {
      request.post("/deleteTeacher", row).then(res => {
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