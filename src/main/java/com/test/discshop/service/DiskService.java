package com.test.discshop.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.test.discshop.domain.Disk;
import com.test.discshop.repository.DiskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiskService {
  @Autowired
  private DiskRepository diskRepository;
  @Autowired
  private TakenItemService takenItemService;

  public Disk findById(Long id) {
    return diskRepository.findById(id).get();
  }
  
  public List<Disk> findAllDisks() {
    return (List<Disk>)diskRepository.findAll();
	}

	public void addNewDisk(Disk disk) {
    diskRepository.save(disk);
  }
  
  public List<Disk> getAvailableDisks(){
    List<Disk> disks = (List<Disk>)diskRepository.findAll();
    Set<Disk> disabledDisks = takenItemService.getDisableDisks().stream()
                                                                .collect(Collectors.toSet());
    List<Disk> availableDisks = disks.stream()
                                      .filter(disk->!disabledDisks.contains(disk))
                                      .collect(Collectors.toList());
    
    return availableDisks;
  }
}