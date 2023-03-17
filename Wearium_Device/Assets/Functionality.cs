using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Functionality : MonoBehaviour
{
    public Material[] materials;
    private int tries = 0;
    private float distance = 0;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if(tries == 10)
        {
           
        }
    }

    public void OnTriggerStay(Collider other)
    {
        
        if (other.gameObject.CompareTag("Hand"))
        {
            this.gameObject.GetComponent<Renderer>().material= materials[1];
            distance = other.gameObject.GetComponent<Transform>().position.x - this.GetComponent<Transform>().position.x;
            this.tries += 1;
        }
    }

    public void OnTriggerExit(Collider other)
    {
        this.gameObject.GetComponent<Renderer>().material = materials[0];
    }
}
