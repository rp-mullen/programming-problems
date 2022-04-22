// problem: implement a hash map from scratch without using any built-in hash table libraries.

#include <iostream>
#include <vector>
#include <algorithm>

class MyHashMap {
public:
    std::vector<std::vector<int>> map;
    std::vector<int> keys;
    
    MyHashMap() {
        
    }
    
    void put(int key, int value) {
        std::vector<int> v = {key, value};
        
        if (count(keys.begin(),keys.end(),key)) {
            auto it = find(keys.begin(),keys.end(),key);            
            int idx = it - keys.begin();
            map[idx][1] = value;
            
        }
        else {
            keys.push_back(key);
            map.push_back(v);
        }
    }
    
    int get(int key) {
        auto it = find(keys.begin(),keys.end(),key);
            if (it != keys.end()){
                int idx = it - keys.begin();
                return map[idx][1];
            }
            else {
                return -1;
            }
        }
    
    
    void remove(int key) {
        auto it = find(keys.begin(),keys.end(),key); 
            if (it != keys.end()) {
                int idx = it - keys.begin();
                map.erase(map.begin() + idx);
                keys.erase(keys.begin() + idx);
        }
    }
};

int main() {
    
    MyHashMap* obj = new MyHashMap();
    
    int key = 1;
    int val = 3;
    
    obj->put(key,val);
    std::cout << "key: " << key << std::endl;
    
    std::cout << "key , value = { " << key << " , " << obj->get(key) << " } " << std::endl;
    obj->remove(key);
    std::cout << "key " << key << " removed." << std::endl;
    std::cout << "key , value = { " << key << " , " << obj->get(key) << " } " << std::endl;
    return 0;
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
