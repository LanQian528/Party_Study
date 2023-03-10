<template>
  <div style="width: 100%;" >
    <el-form style="margin:20px 150px 20px 150px; border: 1px solid #ccc">
      <h2 style="margin: 20px 100px; width: 80%;color: cadetblue">{{papername}}</h2>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>1. {{one.objectpro_com}}</p>
          <el-radio-group v-model="ans.one">
            <el-radio label="A">A.{{one.objectpro_A}}</el-radio>
            <el-radio label="B">B.{{one.objectpro_B}}</el-radio>
            <el-radio label="C">C.{{one.objectpro_C}}</el-radio>
            <el-radio label="D">D.{{one.objectpro_D}}</el-radio>
          </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>2. {{two.objectpro_com}}</p>
        <el-radio-group v-model="ans.two">
          <el-radio label="A">A.{{two.objectpro_A}}</el-radio>
          <el-radio label="B">B.{{two.objectpro_B}}</el-radio>
          <el-radio label="C">C.{{two.objectpro_C}}</el-radio>
          <el-radio label="D">D.{{two.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>3. {{three.objectpro_com}}</p>
        <el-radio-group v-model="ans.three">
          <el-radio label="A">A.{{three.objectpro_A}}</el-radio>
          <el-radio label="B">B.{{three.objectpro_B}}</el-radio>
          <el-radio label="C">C.{{three.objectpro_C}}</el-radio>
          <el-radio label="D">D.{{three.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>4. {{four.objectpro_com}}</p>
        <el-radio-group v-model="ans.four">
          <el-radio label="A">A. {{four.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{four.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{four.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{four.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>5. {{five.objectpro_com}}</p>
        <el-radio-group v-model="ans.five">
          <el-radio label="A">A. {{five.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{five.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{five.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{five.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>6. {{six.objectpro_com}}</p>
        <el-radio-group v-model="ans.six">
          <el-radio label="A">A. {{six.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{six.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{six.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{six.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>7. {{seven.objectpro_com}}</p>
        <el-radio-group v-model="ans.seven">
          <el-radio label="A">A. {{seven.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{seven.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{seven.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{seven.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>8. {{eight.objectpro_com}}</p>
        <el-radio-group v-model="ans.eight">
          <el-radio label="A">A. {{eight.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{eight.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{eight.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{eight.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>9. {{nine.objectpro_com}}</p>
        <el-radio-group v-model="ans.nine">
          <el-radio label="A">A. {{nine.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{nine.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{nine.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{nine.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>10. {{ten.objectpro_com}}</p>
        <el-radio-group v-model="ans.ten">
          <el-radio label="A">A. {{ten.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{ten.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{ten.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{ten.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>11. {{eleven.objectpro_com}}</p>
        <el-radio-group v-model="ans.eleven">
          <el-radio label="A">A. {{eleven.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{eleven.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{eleven.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{eleven.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>12. {{twelve.objectpro_com}}</p>
        <el-radio-group v-model="ans.twelve">
          <el-radio label="A">A. {{twelve.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{twelve.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{twelve.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{twelve.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>13. {{thirteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.thirteen">
          <el-radio label="A">A. {{thirteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{thirteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{thirteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{thirteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>14. {{fourteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.fourteen">
          <el-radio label="A">A. {{fourteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{fourteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{fourteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{fourteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>15. {{fifteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.fifteen">
          <el-radio label="A">A. {{fifteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{fifteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{fifteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{fifteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>16. {{sixteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.sixteen">
          <el-radio label="A">A. {{sixteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{sixteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{sixteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{sixteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>17. {{seventeen.objectpro_com}}</p>
        <el-radio-group v-model="ans.seventeen">
          <el-radio label="A">A. {{seventeen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{seventeen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{seventeen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{seventeen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>18. {{eighteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.eighteen">
          <el-radio label="A">A. {{eighteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{eighteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{eighteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{eighteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>19. {{nineteen.objectpro_com}}</p>
        <el-radio-group v-model="ans.nineteen">
          <el-radio label="A">A. {{nineteen.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{nineteen.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{nineteen.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{nineteen.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>20. {{twenty.objectpro_com}}</p>
        <el-radio-group v-model="ans.twenty">
          <el-radio label="A">A. {{twenty.objectpro_A}}</el-radio>
          <el-radio label="B">B. {{twenty.objectpro_B}}</el-radio>
          <el-radio label="C">C. {{twenty.objectpro_C}}</el-radio>
          <el-radio label="D">D. {{twenty.objectpro_D}}</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
        <p>21. {{twentyone.subpro_com}}</p>
        <el-input v-model="ans.twentyone"/>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
      <p>22. {{twentytwo.subpro_com}}</p>
      <el-input v-model="ans.twentytwo"/>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
      <p>23. {{twentythree.subpro_com}}</p>
      <el-input v-model="ans.twentythree"/>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
      <p>24. {{twentyfour.subpro_com}}</p>
      <el-input v-model="ans.twentyfour"/>
      </el-form-item>
      <el-form-item style="margin: 20px 100px; width: 80%">
      <p>25. {{twentyfive.subpro_com}}</p>
      <el-input v-model="ans.twentyfive"/>
      </el-form-item>
      <el-form-item>
        <el-button style="margin: 20px auto" type="primary" @click="submit">完成考试</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import request from "@/utils/requests";
import {ElMessage} from "element-plus";

export default {
  name: "s_exam",
  data() {
    return {
      one: "",two: "",three: "",four: "",five: "",six: "",seven: "",eight: "",nine: "",ten: "",
      eleven: "",twelve: "",thirteen: "",fourteen: "",fifteen: "",sixteen: "",seventeen: "",eighteen: "",nineteen: "",twenty: "",
      twentyone: "",twentytwo: "",twentythree: "",twentyfour: "",twentyfive: "",
      papername: "",
      ans: {},
      stu_id: window.sessionStorage.getItem("id"),
      paper: window.sessionStorage.getItem("paper"),
      org: window.sessionStorage.getItem("org_id"),
      type: window.sessionStorage.getItem("type"),
      grade: 0,
      all: {},
    }
  },
  created() {
    this.load()
  },
  methods: {
    load() {
      request.get("/getPaperInfoById",{
        params: {"id": this.paper}
      }).then(res => {
        this.papername = res.paperInfo.name
        this.one = res.paperInfo.one
        this.two = res.paperInfo.two
        this.three = res.paperInfo.three
        this.four = res.paperInfo.four
        this.five = res.paperInfo.five
        this.six = res.paperInfo.six
        this.seven = res.paperInfo.seven
        this.eight = res.paperInfo.eight
        this.nine = res.paperInfo.nine
        this.ten = res.paperInfo.ten
        this.eleven = res.paperInfo.eleven
        this.twelve = res.paperInfo.twelve
        this.thirteen = res.paperInfo.thirteen
        this.fourteen = res.paperInfo.fourteen
        this.fifteen = res.paperInfo.fifteen
        this.sixteen = res.paperInfo.sixteen
        this.seventeen = res.paperInfo.seventeen
        this.eighteen = res.paperInfo.eighteen
        this.nineteen = res.paperInfo.nineteen
        this.twenty = res.paperInfo.twenty
        this.twentyone = res.paperInfo.twentyone
        this.twentytwo = res.paperInfo.twentytwo
        this.twentythree = res.paperInfo.twentythree
        this.twentyfour = res.paperInfo.twentyfour
        this.twentyfive = res.paperInfo.twentyfive
      })
    },
    submit() {
      let i = 0
      if(this.one.objectpro_ans === this.ans.one)i++
      if(this.two.objectpro_ans === this.ans.two)i++
      if(this.three.objectpro_ans === this.ans.three)i++
      if(this.four.objectpro_ans === this.ans.four)i++
      if(this.five.objectpro_ans === this.ans.five)i++
      if(this.six.objectpro_ans === this.ans.six)i++
      if(this.seven.objectpro_ans === this.ans.seven)i++
      if(this.eight.objectpro_ans === this.ans.eight)i++
      if(this.nine.objectpro_ans === this.ans.nine)i++
      if(this.ten.objectpro_ans === this.ans.ten)i++
      if(this.eleven.objectpro_ans === this.ans.eleven)i++
      if(this.twelve.objectpro_ans === this.ans.twelve)i++
      if(this.thirteen.objectpro_ans === this.ans.thirteen)i++
      if(this.fourteen.objectpro_ans === this.ans.fourteen)i++
      if(this.fifteen.objectpro_ans === this.ans.fifteen)i++
      if(this.sixteen.objectpro_ans === this.ans.sixteen)i++
      if(this.seventeen.objectpro_ans === this.ans.seventeen)i++
      if(this.eighteen.objectpro_ans === this.ans.eighteen)i++
      if(this.nineteen.objectpro_ans === this.ans.nineteen)i++
      if(this.twenty.objectpro_ans === this.ans.twenty)i++
      this.grade = i * 4
      console.log(this.grade)
      if(this.type === "0"){
        ElMessage({
          type: "success",
          message: "您的客观题得分为"+this.grade+"，客观题总分为80分"
        })
      }
      else if(this.type === "1"){
        this.all = {
          "stuId":this.stu_id,
          "paperId":this.paper,
          "objGrade":this.grade,
          "status": 0,
          "subAnswer":[this.ans.twentyone,this.ans.twentytwo,this.ans.twentythree,this.ans.twentyfour,this.ans.twentyfive],
        }
        request.post("/insertStuAnswer",this.all).then(res =>{
          if(res.code === 200) {
            ElMessage({
              type: "success",
              message: "试卷提交成功"
            })
          }
          else {
            ElMessage({
              type: "error",
              message: "试卷提交失败"
            })
          }
        })
      }
    },
  }
}
</script>

<style scoped>

</style>