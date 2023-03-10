import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import Layout_s from "@/layout/Layout_s";
import Layout_t from "@/layout/Layout_t";

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/login",
    children: [
      {
        path: '/index',
        name: 'Index',
        component: () => import("@/views/admin/Index")
      },
      {
        path: '/stu_ctrl',
        name: 'Stu_ctrl',
        component: () => import("@/views/admin/Stu_ctrl")
      },
      {
        path: '/org_ctrl',
        name: 'Org_ctrl',
        component: () => import("@/views/admin/Org_ctrl")
      },
      {
        path: '/obj_ctrl',
        name: 'Obj_ctrl',
        component: () => import("@/views/admin/Obj_ctrl")
      },
      {
        path: '/sub_ctrl',
        name: 'Sub_ctrl',
        component: () => import("@/views/admin/Sub_ctrl")
      },
      {
        path: '/data_show',
        name: 'Data_show',
        component: () => import("@/views/admin/Data_show")
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import("@/views/Login")
  },
  {
    path: '/s_index',
    name: 's_Layout',
    component: Layout_s,
    children: [
      {
        path: '/s_index',
        name: 's_Index',
        component: () => import("@/views/student/s_Index")
      },
      {
        path: '/s_zice',
        name: 's_zice',
        component: () => import("@/views/student/s_zice")
      },
      {
        path: '/s_kaohe',
        name: 's_kaohe',
        component: () => import("@/views/student/s_kaohe")
      },
      {
        path: '/s_grade',
        name: 's_grade',
        component: () => import("@/views/student/s_grade")
      },
      {
        path: '/s_info',
        name: 's_info',
        component: () => import("@/views/student/s_info")
      },
    ]
  },
  {
    path: '/t_index',
    name: 't_Layout',
    component: Layout_t,
    children: [
      {
        path: '/t_index',
        name: 't_Index',
        component: () => import("@/views/teacher/t_Index")
      },
      {
        path: '/t_stu_ctrl',
        name: 't_Stu_ctrl',
        component: () => import("@/views/teacher/t_Stu_ctrl")
      },
      {
        path: '/t_obj_ctrl',
        name: 't_Obj_ctrl',
        component: () => import("@/views/admin/Obj_ctrl")
      },
      {
        path: '/t_sub_ctrl',
        name: 't_Sub_ctrl',
        component: () => import("@/views/admin/Sub_ctrl")
      },
      {
        path: '/t_data_show',
        name: 't_Data_show',
        component: () => import("@/views/teacher/t_Data_show")
      },
      {
        path: '/t_paper',
        name: 't_Paper',
        component: () => import("@/views/teacher/t_Paper")
      },
      {
        path: '/t_grade',
        name: 't_grade',
        component: () => import("@/views/teacher/t_grade")
      },
    ]
  },
  {
    path: '/s_exam',
    name: 's_exam',
    component: () => import("@/views/student/s_exam")
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
