package com.edigest.start.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.edigest.start.entity.JournalEntity;

@RestController
@RequestMapping("/journal")
public class JournalEntry {
	private Map<Long, JournalEntity> journalEntries = new HashMap<>();

	@GetMapping
	public List<JournalEntity> getAllEntries() {
		return new ArrayList<>(journalEntries.values());
	}

	@PostMapping
	public boolean createEntry(@RequestBody JournalEntity entry) {
		journalEntries.put(entry.getId(), entry);
		return true;
	}

	@GetMapping("id/{myId}")
	public JournalEntity getEntriesById(@PathVariable long myId) {
		return journalEntries.get(myId);
	}

	@DeleteMapping("id/{myId}")
	public JournalEntity deleteEntriesById(@PathVariable long myId) {
		return journalEntries.remove(myId);
	}

	@PutMapping("id/{id}")
	public JournalEntity updateEntriesById(@PathVariable long id, @RequestBody JournalEntity entity) {
		return journalEntries.put(id, entity);
	}
}