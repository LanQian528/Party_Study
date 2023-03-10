<template>
  <div style="width: 100%; height: 100vh; background-color: azure; overflow: hidden">
    <div style="width: 400px; margin: 150px auto">
      <div style="color: cadetblue; font-size: 30px; text-align: center; padding: 30px 0">请登录</div>
      <el-form style="width: 250px;margin: auto;" ref="form" :model="form">
        <el-form-item>
          <el-input
            v-model="form.username"
            type="username"
            placeholder="请输入账户"/>
        </el-form-item>
        <el-form-item>
          <el-input
            v-model="form.password"
            type="password"
            placeholder="请输入密码"
            show-password/>
        </el-form-item>
        <el-form-item>
          <el-radio-group v-model="form.type">
            <el-radio label="3" >学员</el-radio>
            <el-radio label="2" >组织员</el-radio>
            <el-radio label="1" >管理员</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-button style="width: 100%;" type="primary" @click="login">登录</el-button>
      </el-form>

    </div>
  </div>
</template>

<script>
import request from "@/utils/requests";
import {ElMessage} from "element-plus";

export default {
  name: "Login",
  data() {
    return {
     form: {}
    }
  },
  methods: {
    login() {
      request.post("/login",this.form).then(res =>{
        if(res.code === 0) {
          ElMessage({
            type: "error",
            message: "账户或密码错误"
          })
        }
        else {
          ElMessage({
            type: "success",
            message: "登陆成功"
          })
          window.sessionStorage["name"] = res.name
          window.sessionStorage["id"] = res.id
          if(res.code === 1) {
            this.$router.push('/index')
          }
          else if(res.code === 2) {
            this.$router.push("/t_index")
          }
          else if(res.code === 3) {
            this.$router.push("/s_index")
          }
          else {
            ElMessage({
              type: "default",
              message: "登录账户类型出错"
            })
          }
        }
      })
    }
  }
}
</script>

<style scoped>

</style>