import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlashcardSetSearchComponent } from './flashcard-set-search.component';

describe('FlashcardSetSearchComponent', () => {
  let component: FlashcardSetSearchComponent;
  let fixture: ComponentFixture<FlashcardSetSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlashcardSetSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlashcardSetSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
