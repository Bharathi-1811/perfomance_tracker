import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { SignupComponent } from './signup/signup.component';
import { TraineeDashboardComponent } from './trainee-dashboard/trainee-dashboard.component';
import { TraineeAnnounceComponent } from './trainee-announce/trainee-announce.component';
import { TraineeResultComponent } from './trainee-result/trainee-result.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { ManageBatchComponent } from './admin/batch/manage-batch/manage-batch.component';
import { ManageTopicComponent } from './admin/topic/manage-topic/manage-topic.component';
import { CreateTopicComponent } from './admin/topic/create-topic/create-topic.component';
import { UpdateTopicComponent } from './admin/topic/update-topic/update-topic.component';
import { TraineeBodyComponent } from './trainee-body/trainee-body.component';
import { TraineeSidenavComponent } from './trainee-sidenav/trainee-sidenav.component';
import { CreateUpcomingComponent } from './admin/upcomingannouncements/create-upcoming/create-upcoming.component';
import { UpdateUpcomingComponent } from './admin/upcomingannouncements/update-upcoming/update-upcoming.component';
import { ManageUpcomingComponent } from './admin/upcomingannouncements/manage-upcoming/manage-upcoming.component';
import { CreateBatchComponent } from './admin/batch/create-batch/create-batch.component';
import { UpdateBatchComponent } from './admin/batch/update-batch/update-batch.component';
import { CreateBatchTopicComboComponent } from './admin/batchtopiccombo/create-batch-topic-combo/create-batch-topic-combo.component';
import { ManageBatchTopicComboComponent } from './admin/batchtopiccombo/manage-batch-topic-combo/manage-batch-topic-combo.component';
import { EditBatchTopicComboComponent } from './admin/batchtopiccombo/edit-batch-topic-combo/edit-batch-topic-combo.component';
import { ResultAddComponent } from './admin/result/result-add/result-add.component';
import { ResultEditComponent } from './admin/result/result-edit/result-edit.component';
import { ResultManageComponent } from './admin/result/result-manage/result-manage.component';
import { ResultViewComponent } from './admin/result/result-view/result-view.component';
import { ManageTraineeComponent } from './admin/manage-trainees/manage-trainee/manage-trainee.component';
import { AddTraineeComponent } from './admin/manage-trainees/add-trainee/add-trainee.component';
import { UpdateTraineeComponent } from './admin/manage-trainees/update-trainee/update-trainee.component';
import { ManageBatchTraineeComboComponent } from './admin/batchtraineecombo/manage-batch-trainee-combo/manage-batch-trainee-combo.component';
import { CreateBatchTraineeComboComponent } from './admin/batchtraineecombo/create-batch-trainee-combo/create-batch-trainee-combo.component';
import { EditBatchTraineeComboComponent } from './admin/batchtraineecombo/edit-batch-trainee-combo/edit-batch-trainee-combo.component';
import { TraineeGraphComponent } from './trainee-graph/trainee-graph.component';
import { TraineeGraphPiechartComponent } from './admin/result/graph-piechart/trainee-graph-piechart.component';
import { ViewprofileComponent } from './traineeprofile/viewprofile/viewprofile.component';
import { EditprofileComponent } from './traineeprofile/editprofile/editprofile.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { AdminTraineeViewComponent } from './admin-trainee-view/admin-trainee-view.component';
import { TraineeTopicComponent } from './trainee-topic/trainee-topic.component';

const routes: Routes = [
 {
  path:'',
  component:HomeComponent
 },
 {
  path:"home",
  component:HomeComponent
 },
 {
  path:"signup/:zid",
  component:SignupComponent
 },
 {
  path:"login",
  component:LoginComponent
 },
 {
  path:"adminlogin",
  component:AdminloginComponent
 },
 {
  path:'dashboard',
  component:TraineeDashboardComponent
 },
 {
  path:'announce',
  component:TraineeAnnounceComponent
 },
 {
  path:'result',
  component:TraineeResultComponent
 },
 {
  path:'dashboardsection',
  component:AdminDashboardComponent
 },
 {  
  path:'createbatch',
  component:CreateBatchComponent
 },
 {
  path:'updatebatch/:id',
  component:UpdateBatchComponent
 },
 {
  path:'managebatch',
  component:ManageBatchComponent
 },
 {
  path:'managetopic',
  component:ManageTopicComponent
 },
 {
  path:'createtopic',
  component:CreateTopicComponent
 },
 {
  path:'updatetopic/:id',
  component:UpdateTopicComponent
 },
 {
  path:'manageupcomingtest',
  component:ManageUpcomingComponent
 },
 {
  path:'createupcomingtest',
  component:CreateUpcomingComponent
 },
 {
  path:'updateupcomingtest/:id',
  component:UpdateUpcomingComponent
 }, 
 {
  path:'createbtcombination',
  component:CreateBatchTopicComboComponent
 },
 {
  path:'managebtcombination',
  component:ManageBatchTopicComboComponent
 },
 {
  path:'updatebtcombination/:id',
  component:EditBatchTopicComboComponent
 },
 {
  path:'addresult/:id',
  component:ResultAddComponent
 },
 {
  path:'editresult/:id/:value',
  component:ResultEditComponent
 },
 {
  path:'manageresult',
  component:ResultManageComponent
 },
 {
  path:'viewresult/:id',
  component:ResultViewComponent
 },
 {
  path:'managetrainee',
  component:ManageTraineeComponent
 },
 {
  path:'addtrainee',
  component:AddTraineeComponent
 },
 {
  path:'updatetrainee/:id',
  component:UpdateTraineeComponent
 },
 {
  path:'managebatchtraineecombo',
  component:ManageBatchTraineeComboComponent
 },
 {
  path:'addbatchtraineecombo',
  component:CreateBatchTraineeComboComponent
 },
 {
  path:'updatebatchtraineecombo/:id',
  component:EditBatchTraineeComboComponent
 },

 {
  path:'traineegraph/:id/:zid',
  component:TraineeGraphComponent
 },
 {
  path:'traineepiechart/:id',
  component:TraineeGraphPiechartComponent
 },
 
 //profile routing
 {
  path:'traineeviewprofile',
  component:ViewprofileComponent
},
{
  path:'traineeeditprofile',
  component:EditprofileComponent
},

{
  path:'changepassword',
  component:ChangepasswordComponent
},

//admindashbord
{
  path:'admintraineeview/:value',
  component:AdminTraineeViewComponent
},

//trainee dashboard topic list 
{
  path:'traineetopic/:id/:zid',
  component:TraineeTopicComponent
}



//  {
//   path:'updatetopic/:id',
//   component:TraineeSidenavComponent,

//   children:[
//       {
//         path:'',
//         component:UpdateTopicComponent
//        }
//   ]
  
// }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
