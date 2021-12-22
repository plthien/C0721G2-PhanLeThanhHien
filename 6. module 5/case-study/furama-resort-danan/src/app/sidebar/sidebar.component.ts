import {Component, OnInit} from '@angular/core';

declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/employees', title: 'Employee',  icon: 'groups', class: '' },
  { path: '/customers', title: 'Customer',  icon: 'supervised_user_circle', class: '' },
  { path: '/facilities', title: 'Facility',  icon: 'house_siding', class: '' },
  { path: '/contracts', title: 'Facility',  icon: 'library_books', class: '' },
];


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() {
  }

  ngOnInit(): void {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  }
}
