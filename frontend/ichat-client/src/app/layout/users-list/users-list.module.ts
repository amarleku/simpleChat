import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../../shared/module/shared.module';
import { CommonModule } from '@angular/common';

import { UsersListComponent } from './users-list.component';
import {MatPaginatorModule} from '@angular/material/paginator';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    MatPaginatorModule
  ],
  declarations: [UsersListComponent],
  exports: [UsersListComponent]
})
export class UsersListModule {
}
