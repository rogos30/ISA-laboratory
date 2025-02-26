import {Component, OnInit} from '@angular/core';
import {AlienService} from '../../service/alien.service';
import {Aliens} from '../../model/aliens';
import {Alien} from '../../model/alien';

@Component({
  selector: 'app-alien-list',
  templateUrl: './alien-list.component.html',
  standalone: false,
  styleUrls: ['./alien-list.component.css']
})
export class AlienListComponent implements OnInit {
  constructor(private service: AlienService) {
  }

  aliens: Aliens | undefined;

  ngOnInit() {
    this.service.getAliens().subscribe(aliens => this.aliens = aliens);
  }

  onDelete(alien: Alien): void {
    this.service.deleteAlien(alien.id).subscribe(() => this.ngOnInit());
  }
}
