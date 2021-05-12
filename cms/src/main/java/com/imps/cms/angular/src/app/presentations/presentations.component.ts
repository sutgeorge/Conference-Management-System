import { Component, OnInit } from '@angular/core';
import {Conference} from "./model/conference";
import {ConferenceService} from "./service/conference.service";
import {Deadline} from "./model/deadline";
import {UserDto} from "../authentication/model/UserDto";

@Component({
  selector: 'app-presentations',
  templateUrl: './presentations.component.html',
  styleUrls: ['./presentations.component.css']
})
export class PresentationsComponent implements OnInit {
  conferences: Conference[];
  deadlinesDictionary: {[id: number] : Deadline[]}= {}
  toggleDictionary: {[id: number] : boolean} = {}

  constructor(private conferenceService: ConferenceService) { }

  ngOnInit(): void {
    this.getConferences();
  }

  getConferences(): void {
    this.conferenceService.getConferences().subscribe(conferences => {
      console.log("The requested conferences: ", conferences);
      this.conferences = conferences;
      for(let i = 0; i < this.conferences.length; i++){
        this.toggleDictionary[conferences[i].id] = false;
        this.deadlinesDictionary[conferences[i].id] = [];
      }
    });
  }

  getDeadlinesForConference(id: number) {
    this.conferenceService.getDeadlinesForConferenceId(id).subscribe(deadlines =>{
      console.log("The requested deadlines: ", deadlines);
      this.deadlinesDictionary[id] = deadlines;
      this.toggleDictionary[id] = ! this.toggleDictionary[id];
    })
  }
}