package com.test.discshop.service;

import java.util.List;
import java.util.stream.Collectors;

import com.test.discshop.domain.Disk;
import com.test.discshop.domain.TakenItem;
import com.test.discshop.domain.User;
import com.test.discshop.repository.TakenItemRepository;
import com.test.discshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakenItemService {
  @Autowired
  private TakenItemRepository takenItemRepository;
  @Autowired
  private UserRepository userRepository;

  public TakenItem findById(Long id) {
		return takenItemRepository.findById(id).get();
	}

  public List<TakenItem> takenItemsByCurrentUser(String username) {
    User currentUser = userRepository.findByUsername(username);
    return takenItemRepository.findByUser(currentUser).get();
  }

  public List<TakenItem> takenItemsByUsers() {
    return (List<TakenItem>) takenItemRepository.findAll();
  }

  public List<Disk> getDisableDisks() {
    List<TakenItem> takenItems = (List<TakenItem>) takenItemRepository.findAll();
    List<Disk> disableDisks = takenItems.stream()
                                        .map(takenItem->takenItem.getDisk())
                                        .collect(Collectors.toList());
    return disableDisks;
  }

  public void addTakenItem(String username, Disk disk) {
    TakenItem takenitem = new TakenItem(userRepository.findByUsername(username), disk);
    takenItemRepository.save(takenitem);
  }

  public void removeTakenItem(String username, Disk disk) {
    TakenItem takenItem = takenItemRepository.findTakenItemByUserAndDisk(userRepository.findByUsername(username), disk);
    takenItemRepository.delete(takenItem);
  }

  public TakenItem createNewTakenItem(User user, Disk disk){
    return new TakenItem(user, disk);
  }
}